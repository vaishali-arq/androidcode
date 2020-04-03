package com.example.androidcode.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcode.home.domain.ListDataUserCase
import com.example.androidcode.home.presentation.data.ListResultView
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val listResult = MutableLiveData<ListResultView>()

    val listDataUserCase = ListDataUserCase()

    fun callWebservice() {
        viewModelScope.launch {
            try {
                val response = listDataUserCase.callWebservice()
                listResult.value = ListResultView(success = response)
            } catch (exception: Exception) {

            }
        }
    }
}