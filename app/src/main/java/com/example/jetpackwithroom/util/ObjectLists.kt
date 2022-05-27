package com.example.jetpackwithroom.util

import com.example.jetpackwithroom.database.Library
import com.example.jetpackwithroom.database.User

object ObjectLists {
    fun userList(): List<User> {
        return listOf(
            User(1, "User 1", 10),
            User(2, "User 2", 11),
            User(3, "User 3", 12),
            User(4, "User 4", 13),
            User(5, "User 5", 14)
        )
    }
    fun libraryList(): List<Library> {
        return listOf(
            Library(1, "Library 1", 5),
            Library(2, "Library 2", 4),
            Library(3, "Library 3", 3),
            Library(4, "Library 4", 2),
            Library(5, "Library 5", 1)
        )
    }
}