package com.example.contextmonitoringapp_project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.contextmonitoringapp_project1.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main0)

        val buttonRecord = findViewById<Button>(R.id.button_Record)
        buttonRecord.setOnClickListener {
            val intent_record = Intent(this, MainActivity1::class.java)
            startActivity(intent_record)
        }

        val buttonDelete = findViewById<Button>(R.id.button_delete)
        buttonDelete.setOnClickListener {
            lifecycleScope.launch {
                val db = AppDatabase.getDatabase(this@MainActivity0)
                withContext(Dispatchers.IO) {
                    db.recordsDao().deleteAll()
                }
                Toast.makeText(this@MainActivity0, "All data deleted", Toast.LENGTH_SHORT).show()
            }
        }
    } }