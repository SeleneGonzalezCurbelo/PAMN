package com.example.sirius.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sirius.AnimalApplication
import com.example.sirius.data.dao.UserDao
import com.example.sirius.model.User
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserViewModel(private val userDao: UserDao) : ViewModel() {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser //datastore?
    private val _favoriteStatus = MutableStateFlow(false)
    val favoriteStatus: StateFlow<Boolean> = _favoriteStatus.asStateFlow()

    suspend fun login(username: String, password: String): Boolean {
        return suspendCoroutine { continuation ->
            viewModelScope.launch {
                try {
                    if (username.isBlank() || password.isBlank()) {
                        continuation.resume(false)
                        return@launch
                    }
                    val user = getUserByCredentials(username, password)
                    val success = user != null
                    if (user != null) {
                        _currentUser.value = user
                        saveAuthenticationState(user)
                    }
                    continuation.resume(success)
                } catch (e: Exception) {
                    e.printStackTrace()
                    continuation.resume(false)
                }
            }
        }
    }

    fun getAuthenticatedUser(): User? {
        return _currentUser.value
    }

    private fun saveAuthenticationState(user: User?) {
        val sharedPreferences = AnimalApplication.context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            if (user != null)
                putString("user_info", Gson().toJson(user))
            else
                remove("user_info")
            apply()
        }
    }

    suspend fun registerUser(username: String, email: String, password: String): Boolean {
        if (username.isBlank() || email.isBlank() || password.isBlank()) return false
        if (!checkIfUserExists(username)) {
            return try {
                val newUser = User(
                    username = username,
                    email = email,
                    password = password,
                    role = "user"
                )

                viewModelScope.launch {
                    withContext(Dispatchers.IO) {
                        userDao.insertUser(newUser)
                        _currentUser.value = newUser
                        saveAuthenticationState(newUser)
                    }
                }
                true
            } catch (e: Exception) {
                println("error al insertar")
                e.printStackTrace()
                false
            }
        }
        return false
    }

    suspend fun logout() {
        _currentUser.value = null
        saveAuthenticationState(null)
    }

    suspend fun checkIfUserExists(username: String): Boolean {
        if (getUserByUsername(username) != null) return true
        return false
    }

    suspend fun updateUser() {}

    suspend fun getUserById(userId: Int): User? {
        return userDao.getUserById(userId)
    }

    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }

    suspend fun getUserByCredentials(username: String, password: String): User? {
        return userDao.getUserByCredentials(username, password)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    suspend fun insertUser(user: User) {
        viewModelScope.launch { userDao.insertUser(user) }

    }

    suspend fun updateFavorites(user: User, newFavorites: String) {
        println("newFavorites")
        println(newFavorites)
        viewModelScope.launch {
            // Elimina cualquier ocurrencia de "null" y maneja las comas al principio y al final
            user.favorites = user.favorites
                ?.replace("null,", "")
                ?.replace("^,|,$".toRegex(), "") // Elimina comas al principio o al final
                ?: ""

            user.favorites = newFavorites

            // Actualiza el usuario en la base de datos
            userDao.update(user)
            println("Favorites updated: $newFavorites")
            println(user)
        }
    }

    suspend fun updateUserName(user: User, newUserName: String){
        user.username = newUserName
        println(newUserName)
        println(user)
        userDao.update(user)
    }

    suspend fun updatePassword(user: User, newPassword: String){
        user.password = newPassword
        println(newPassword)
        println(user)
        userDao.update(user)
    }

    suspend fun getFavoritesByUsername(username: String): String? {
        return userDao.getFavoritesByUsername(username)
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AnimalApplication)
                UserViewModel(application.database.userDao())
            }
        }
    }
}