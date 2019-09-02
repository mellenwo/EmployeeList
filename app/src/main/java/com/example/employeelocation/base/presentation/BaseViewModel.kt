package com.example.employeelocation.base.presentation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(private val baseCoroutineDispatcher: CoroutineDispatcher): ViewModel(),
                                                                                        CoroutineScope {

    private var baseCoroutineScope: CoroutineScope? = null

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    open fun setTestCoroutineContext(coroutineScope: CoroutineScope?) {
        this.baseCoroutineScope = coroutineScope
    }

    override val coroutineContext: CoroutineContext
        get() = baseCoroutineScope?.coroutineContext ?: baseCoroutineDispatcher+viewModelJob

    private val viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun loadData() {
        onLoadData()
    }

    protected open fun onLoadData() {}

}