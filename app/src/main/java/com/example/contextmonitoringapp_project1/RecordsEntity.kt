package com.example.contextmonitoringapp_project1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class RecordsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val nausea: Int = 0,
    val headache: Int = 0,
    val diarrhea: Int = 0,
    val soreThroat: Int = 0,
    val fever: Int = 0,
    val muscleAche: Int = 0,
    val lossSmellTaste: Int = 0,
    val cough: Int = 0,
    val shortnessOfBreath: Int = 0,
    val feelingTired: Int = 0,
    val heartRate: Int? = null,
    val respiratoryRate: Int? = null
)
