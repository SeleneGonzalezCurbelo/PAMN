package com.example.sirius.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sirius.model.Animal

@Database(entities = [Animal::class], version = 1, exportSchema = false)
abstract class AnimalDatabase: RoomDatabase() {
    abstract fun animalDao(): AnimalDao
    //Intentar usar singletoon
    companion object {
        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun getDatabase(context: Context): AnimalDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AnimalDatabase::class.java,
                    "app_database"
                )
                    // Base de datos de inicialización
                    .createFromAsset("database/Animal.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}