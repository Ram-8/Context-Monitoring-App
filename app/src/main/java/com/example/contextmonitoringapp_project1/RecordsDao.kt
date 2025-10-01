package com.example.contextmonitoringapp_project1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecordsDao {
    @Insert
    suspend fun insert(recordsEntity: RecordsEntity): Long

    @Query("SELECT * FROM records ORDER BY timestamp DESC")
    suspend fun getAllRecords(): List<RecordsEntity>

    @Query("DELETE FROM records")
    suspend fun deleteAll(): Int
}