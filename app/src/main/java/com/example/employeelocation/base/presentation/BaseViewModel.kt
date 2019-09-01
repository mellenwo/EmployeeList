package com.example.employeelocation.base.presentation

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    fun loadData() {
        onLoadData()
    }

    protected open fun onLoadData() {}

}