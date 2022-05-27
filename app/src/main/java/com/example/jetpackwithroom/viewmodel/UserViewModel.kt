package com.example.jetpackwithroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jetpackwithroom.database.Library
import com.example.jetpackwithroom.database.User
import com.example.jetpackwithroom.database.UserAndLibrary
import com.example.jetpackwithroom.database.UserDatabase
import com.example.jetpackwithroom.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(app: Application) : AndroidViewModel(app) {
    private val _readAllData: MutableLiveData<List<UserAndLibrary>> = MutableLiveData()
    val readAllData: LiveData<List<UserAndLibrary>> get() = _readAllData
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.invoke(app).userDao()
        repository = UserRepository(userDao)
    }

    fun getUser(userId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _readAllData.postValue(repository.getUserData(userId))
    }
    fun addUsers(items: List<User>) = viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(items)
    }
    fun addLibraries(items: List<Library>) = viewModelScope.launch(Dispatchers.IO) {
        repository.addLibrary(items)
    }
}