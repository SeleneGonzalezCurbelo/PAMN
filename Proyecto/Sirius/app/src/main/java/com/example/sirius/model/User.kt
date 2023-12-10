package com.example.sirius.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user", indices = [Index(value = ["username"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @NonNull
    @ColumnInfo(name = "username")
    var username: String,
    @NonNull
    @ColumnInfo(name = "email")
    val email: String,
    @NonNull
    @ColumnInfo(name = "password")
    var password: String,
    @NonNull
    @ColumnInfo(name = "role")
    //Enumerado
    val role: String,
    @ColumnInfo(name = "favorites")
    var favorites: String? = null
    // Image, Favourites
)