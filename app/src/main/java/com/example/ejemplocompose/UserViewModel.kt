package com.example.ejemplocompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejemplocompose.model.User
import com.example.ejemplocompose.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private  val userRepo: UserRepository
): ViewModel() {

    private  val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val users: LiveData <List<User>> by lazy {
        userRepo.getAllUser()
    }

    val isLoading: LiveData <Boolean> get () = _isLoading

    fun addUser () {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            userRepo.getNewUser()
            _isLoading.postValue(true)
        }

        fun deleteUser (toDelete: User){
            viewModelScope.launch(Dispatchers.IO) {
                userRepo.deleteUser(toDelete)
            }
        }
    }

}