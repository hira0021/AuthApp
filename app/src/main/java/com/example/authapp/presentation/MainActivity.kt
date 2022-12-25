package com.example.authapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.authapp.databinding.ActivityMainBinding
import com.example.authapp.domain.Entity.Todo
import com.example.authapp.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        viewModel.setStateEvent()

        viewModel.dataState.observe(this) {
            when (it) {
                is DataState.Success -> {
                    processSuccess(it.data)
                    stopLoading()
                }
                is DataState.Error -> {
                    processFailure(it.exception)
                    stopLoading()
                }
                is DataState.Loading -> {
                    showLoading()
                }
            }
        }
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun stopLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun processSuccess(data: List<Todo>) {
        if(data != null) {
            todoAdapter.todos = data
        }
    }

    private fun processFailure(exception: Exception) {
        Log.e("MyTag", exception.message.toString())
    }
}