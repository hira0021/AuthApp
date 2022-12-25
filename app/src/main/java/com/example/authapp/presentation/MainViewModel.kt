package com.example.authapp.presentation

import androidx.lifecycle.*
import com.example.authapp.data.repository.TodoRepository
import com.example.authapp.domain.Entity.Todo
import com.example.authapp.domain.usecase.TodoUseCase
import com.example.authapp.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val todoUseCase: TodoUseCase
) : ViewModel() {
    private var _dataState: MutableLiveData<DataState<List<Todo>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Todo>>> = _dataState

    //var data: LiveData<DataState<List<Todo>>> = MutableLiveData()

    fun setStateEvent() = viewModelScope.launch {
        //data = todoUseCase.getTodos().asLiveData()
        //_dataState.value = todoUseCase.getTodos()

        todoUseCase.getTodos()
            .flowOn(Dispatchers.IO)
            .catch { e ->

            }
            .collect {
                _dataState.value = it
            }
    }
}