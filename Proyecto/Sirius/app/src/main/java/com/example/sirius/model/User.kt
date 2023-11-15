package com.example.sirius.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @NonNull
    @ColumnInfo(name = "username")
    val username: String,
    @NonNull
    @ColumnInfo(name = "email")
    val email: String,
    @NonNull
    @ColumnInfo(name = "password")
    val password: String,
    @NonNull
    @ColumnInfo(name = "role")
    //Enumerado
    val role: String,
    // Image, Favourites
)