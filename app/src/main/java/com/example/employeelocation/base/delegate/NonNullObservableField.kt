package com.example.employeelocation.base.delegate

import androidx.databinding.ObservableField

open class NonNullObservableField<T : Any>(defaultValue: T) : ObservableField<T>(defaultValue) {

    //This override is not redundant, it gives us kotlin null-safety
    override fun set(value: T) {
        super.set(value)
    }

    override fun get(): T {
        return super.get()!!
    }
}