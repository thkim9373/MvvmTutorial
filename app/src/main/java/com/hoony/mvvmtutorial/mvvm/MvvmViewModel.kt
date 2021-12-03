package com.hoony.mvvmtutorial.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MvvmViewModel : ViewModel() {

    private val _counterLiveData = MutableLiveData(0)
    val counterLiveData: LiveData<Int>
        get() = _counterLiveData

    fun plus() {
        _counterLiveData.value = _counterLiveData.value.orZero() + 1
    }

    fun minus() {
        _counterLiveData.value = _counterLiveData.value.orZero() - 1
    }

    private fun Int?.orZero(): Int = this ?: 0
}