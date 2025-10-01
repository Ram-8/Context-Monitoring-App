package com.example.contextmonitoringapp_project1

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.contextmonitoringapp_project1.data.AppDatabase
import com.example.contextmonitoringapp_project1.RecordsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {

    private var heartRate: Int? = null
    private var respiratoryRate: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        heartRate = intent.getIntExtra("heartRate", 0).takeIf { it != 0 }
        respiratoryRate = intent.getIntExtra("respiratoryRate", 0).takeIf { it != 0 }

        setupRatingBars()
        
        val buttonSaveAll = findViewById<Button>(R.id.button_save_all)
        buttonSaveAll.setOnClickListener {
            lifecycleScope.launch {
                val db = AppDatabase.getDatabase(this@MainActivity2)
                val entity = RecordsEntity(
                    nausea = findViewById<RatingBar>(R.id.rating_nausea).rating.toInt(),
                    headache = findViewById<RatingBar>(R.id.rating_headache).rating.toInt(),
                    diarrhea = findViewById<RatingBar>(R.id.rating_diarrhea).rating.toInt(),
                    soreThroat = findViewById<RatingBar>(R.id.rating_sore_throat).rating.toInt(),
                    fever = findViewById<RatingBar>(R.id.rating_fever).rating.toInt(),
                    muscleAche = findViewById<RatingBar>(R.id.rating_muscle_ache).rating.toInt(),
                    lossSmellTaste = findViewById<RatingBar>(R.id.rating_loss_smell_taste).rating.toInt(),
                    cough = findViewById<RatingBar>(R.id.rating_cough).rating.toInt(),
                    shortnessOfBreath = findViewById<RatingBar>(R.id.rating_shortness_of_breath).rating.toInt(),
                    feelingTired = findViewById<RatingBar>(R.id.rating_feeling_tired).rating.toInt(),
                    heartRate = heartRate,
                    respiratoryRate = respiratoryRate
                )
                withContext(Dispatchers.IO) {
                    db.recordsDao().insert(entity)
                }
                Toast.makeText(this@MainActivity2, "Data saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRatingBars() {
        val ratingBars = listOf(
            R.id.rating_nausea to R.id.text_nausea,
            R.id.rating_headache to R.id.text_headache,
            R.id.rating_diarrhea to R.id.text_diarrhea,
            R.id.rating_sore_throat to R.id.text_sore_throat,
            R.id.rating_fever to R.id.text_fever,
            R.id.rating_muscle_ache to R.id.text_muscle_ache,
            R.id.rating_loss_smell_taste to R.id.text_loss_smell_taste,
            R.id.rating_cough to R.id.text_cough,
            R.id.rating_shortness_of_breath to R.id.text_shortness_of_breath,
            R.id.rating_feeling_tired to R.id.text_feeling_tired
        )

        ratingBars.forEach { (ratingId, textId) ->
            val ratingBar = findViewById<RatingBar>(ratingId)
            val textView = findViewById<TextView>(textId)
            
            ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
                val symptomName = textView.text.toString().split(":")[0]
                textView.text = "$symptomName: ${rating.toInt()}"
            }
        }
    }
}