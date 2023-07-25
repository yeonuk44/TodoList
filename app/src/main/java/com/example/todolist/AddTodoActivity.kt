package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.todolist.databinding.ActivityMainBinding

class AddTodoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)



        setContentView(binding.root)

        btn = findViewById(R.id.btn_add_todo)

//        btn.setOnClickListener()
//
//        binding.btnAddTodo.setOnClickListener()
    }
}