package com.example.sirius.view.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sirius.AnimalApplication
import com.example.sirius.model.Animal
import com.example.sirius.model.AnimalDao
import kotlinx.coroutines.flow.Flow

class AnimalViewModel(private val animalDao: AnimalDao) : ViewModel() {
    fun getAllAnimals(): Flow<List<Animal>> = animalDao.getAllAnimals()

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AnimalApplication)
                AnimalViewModel(application.database.animalDao())
            }
        }
    }
}