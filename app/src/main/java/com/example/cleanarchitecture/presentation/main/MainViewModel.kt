package com.example.cleanarchitecture.presentation.main

import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel: BaseViewModel() {
    override fun fetchData(): Job = viewModelScope.launch {  }
}