package co.apploop.ktorexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.apploop.ktorexample.model.Response
import co.apploop.ktorexample.repo.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val responseFlow = MutableStateFlow<Response?>(null)

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                Repository.getUserData()
            }.onSuccess {
                responseFlow.value = it
            }.onFailure {
                responseFlow.value = null
            }
        }
    }
}