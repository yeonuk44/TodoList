package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding
import com.example.todolist.db.TodoEntity

class TodoRecyclerViewAdapter(private val todoList: ArrayList<TodoEntity>) : RecyclerView.Adapter<TodoRecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        val tv_importance = binding.tvImportance
        val tv_title = binding.tvTitle

        val root = binding.root
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ItemTodoBinding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    }
}