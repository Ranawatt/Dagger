package com.example.dagger_hilt.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt.data.model.User
import com.example.dagger_hilt.data.repository.MainRepository
import com.example.dagger_hilt.utils.NetworkHelper
import com.example.dagger_hilt.utils.Resource
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
        private val repository: MainRepository,
        private val networkHelper: NetworkHelper) : ViewModel(){
    private val _users = MutableLiveData<Resource<List<User>>>()
    val  users:LiveData<Resource<List<User>>>  get() =  _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                repository.getUsers().let {
                    if (it.isSuccessful){
                        _users.postValue(Resource.success(it.body()))
                    }else{
                        _users.postValue(Resource.error(it.errorBody().toString(),null))
                    }
                }
            }else{
                _users.postValue(Resource.error("No Internet Connection", null))
            }
        }
    }
}