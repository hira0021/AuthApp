package com.example.authapp.util

sealed class DataState<out R> {

    data class Success<out T>(val data: T): DataState<T>()
    data class Error(val exception: java.lang.Exception): DataState<Nothing>()
    object Loading: DataState<Nothing>()

}