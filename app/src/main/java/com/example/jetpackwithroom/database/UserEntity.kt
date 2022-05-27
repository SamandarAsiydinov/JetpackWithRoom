package com.example.jetpackwithroom.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "User")
data class User(
    @PrimaryKey
    val userId: Int,
    val name: String,
    val age: Int
)

@Entity(tableName = "Library")
data class Library(
    @PrimaryKey
    val id: Int,
    val title: String,
    val userOwnerId: Int
)

data class UserAndLibrary(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val library: Library
)