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

    /**
     * Info
     * onCreateViewHolder: MyViewHolder의 데이터를 받아 ViewHoler 객체를 만든다.
     * onBindViewHolder: MyViewHolder 객체에 데이터를 넣는다.
     * getItemCount: 아이템의 수가 몇 개인지 반환하는 객체이다.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ItemTodoBinding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todoData = todoList[position]

        when(todoData.importance){
            1 -> {
                holder.tv_importance.setBackgroundResource(R.color.red)
            }
            2 -> {
                holder.tv_importance.setBackgroundResource(R.color.yellow)
            }
            3->{
                holder.tv_importance.setBackgroundResource(R.color.green)

            }
        }

        holder.tv_importance.text = todoData.importance.toString()
        holder.tv_title.text = todoData.title
    }

    override fun getItemCount(): Int {
        return todoList.size
    }




}