package com.example.androidcode.home.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcode.R
import com.example.androidcode.home.domain.ListDataUserCase
import com.example.androidcode.home.domain.data.ResultWrapper
import com.example.androidcode.home.presentation.data.ListResultView
import kotlinx.coroutines.launch

class MainViewModel constructor(val context: Context) : ViewModel() {

    var activityContext = this.context
    val listResult = MutableLiveData<ListResultView>()
    val progressState = MutableLiveData<Boolean>()

    val listDataUserCase = ListDataUserCase()

    fun callWebservice() {
        progressState.value = true
        viewModelScope.launch {
            val response = listDataUserCase.callWebservice()
            progressState.value = false
            when (response) {
                is ResultWrapper.Success -> listResult.value =
                    ListResultView(success = response.value)
                is ResultWrapper.NetworkError -> {
                    listResult.value = ListResultView(
                        errorMsg = activityContext.resources.getString(
                            R.string.error_no_internet_connection_message
                        )
                    )
                }
                is ResultWrapper.GenericError -> {
                    listResult.value = ListResultView(errorMsg = response.errorMessage)
                }
            }
        }
    }
}