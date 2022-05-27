package com.example.jetpackwithroom.database

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(items: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibrary(items: List<Library>)

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUsersAndLibraries(userId: Int): List<UserAndLibrary>
}