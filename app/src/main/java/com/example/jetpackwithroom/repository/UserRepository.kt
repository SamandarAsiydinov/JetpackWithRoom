package com.example.jetpackwithroom.repository

import androidx.lifecycle.LiveData
import com.example.jetpackwithroom.database.Library
import com.example.jetpackwithroom.database.User
import com.example.jetpackwithroom.database.UserAndLibrary
import com.example.jetpackwithroom.database.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<UserAndLibrary>>? = null

    suspend fun addUser(items: List<User>) {
        userDao.insertUser(items)
    }

    suspend fun addLibrary(items: List<Library>) {
        userDao.insertLibrary(items)
    }

    fun getUserData(userId: Int): List<UserAndLibrary> {
        return userDao.getUsersAndLibraries(userId)
    }
}