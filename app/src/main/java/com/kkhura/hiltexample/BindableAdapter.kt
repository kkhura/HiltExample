package com.kkhura.hiltexample

interface BindableAdapter<T> {
    fun setData(data: List<T>?)
}