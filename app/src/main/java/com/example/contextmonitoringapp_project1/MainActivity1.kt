package com.example.contextmonitoringapp_project1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity1 : AppCompatActivity() {
    private var HeartRate: Int? = null
    private var RespiratoryRate: Int? = null

    private val pickVideoLauncher = registerForActivityResult(ActivityResultContracts.OpenDocument())
    { uri: Uri? ->
        uri?.let {
            lifecycleScope.launch()
            {
                val currentHeartRate = HeartRateCalculator().calculate(uri, contentResolver)
                HeartRate = currentHeartRate
            }
        } }

    private val pickRespiratoryFilesLauncher = registerForActivityResult(ActivityResultContracts.OpenMultipleDocuments())
    { uris: List<Uri> ->
        if (uris.size != 3) return@registerForActivityResult
        uris.forEach { uri ->
            try {
                contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            } catch (_: Exception) {}
        }
        
        lifecycleScope.launch {
            val xValues = readSingleColumnCsv(uris[0])
            val yValues = readSingleColumnCsv(uris[1])
            val zValues = readSingleColumnCsv(uris[2])
            val rr = respiratoryRateCalculator(xValues, yValues, zValues)
            RespiratoryRate = rr
        } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        findViewById<Button>(R.id.button_heart).setOnClickListener {
            pickVideoLauncher.launch(arrayOf("video/*"))
        }

        findViewById<Button>(R.id.button_respiratory).setOnClickListener {
            pickRespiratoryFilesLauncher.launch(arrayOf("text/*", "text/csv"))
        }

        findViewById<Button>(R.id.button_check_symptoms).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("heartRate", HeartRate ?: 0)
            intent.putExtra("respiratoryRate", RespiratoryRate ?: 0)
            startActivity(intent)
        } }

    private fun readSingleColumnCsv(uri: Uri): MutableList<Float> {
        val values = mutableListOf<Float>()
        try {
            contentResolver.openInputStream(uri)?.use { input ->
                BufferedReader(InputStreamReader(input)).use { reader ->
                    reader.lineSequence().forEach { line ->
                        val token = line.split(',', ';', '\t').firstOrNull()?.trim()
                        val v = token?.toFloatOrNull()
                        if (v != null) values.add(v)
                    }
                }
            }
        } catch (_: Exception) {}
        return values
    } }