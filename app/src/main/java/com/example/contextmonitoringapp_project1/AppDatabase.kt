package com.example.contextmonitoringapp_project1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contextmonitoringapp_project1.RecordsDao
import com.example.contextmonitoringapp_project1.RecordsEntity

@Database(entities=[RecordsEntity::class], version = 5)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun recordsDao(): RecordsDao
    companion object {
        @Volatile
        private var Instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                if (Instance == null)
                {
                    val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "heart_rate_database")
                        .build()
                    Instance = instance
                }
                Instance!!
            }
        }
    } }