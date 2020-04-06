package com.example.androidcode.home.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcode.R
import com.example.androidcode.home.domain.FactsUseCase
import com.example.androidcode.home.domain.data.ResultWrapper
import com.example.androidcode.home.presentation.data.ListResultView
import kotlinx.coroutines.launch

/**
 *
 * MainViewModel is ViewModel class to handle webservice calls and logic
 * It uses MutableLiveData which is observed in activity
 */
class MainViewModel constructor(val context: Context) : ViewModel() {

    var activityContext = this.context
    val listResult = MutableLiveData<ListResultView>()
    val progressState = MutableLiveData<Boolean>()

    val factsUseCase = FactsUseCase()

    fun callWebservice() {
        progressState.value = true
        viewModelScope.launch {
            val response = factsUseCase.callWebservice()
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