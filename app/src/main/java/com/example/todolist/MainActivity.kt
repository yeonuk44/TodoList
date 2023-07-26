package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.db.AppDatabase
import com.example.todolist.db.TodoDao
import com.example.todolist.db.TodoEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var db : AppDatabase
    private lateinit var todoDao : TodoDao
    private lateinit var todoList: ArrayList<TodoEntity>
    private lateinit var adapter: TodoRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)!!
        todoDao = db.getTodoDao()

        getAllTodoList()

        binding.btnAddTodo.setOnClickListener {
            val intent = Intent(this,AddTodoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllTodoList(){
        Thread{
            todoList = ArrayList(todoDao.getAllTodo())
            setRecyclerView()

        }
    }

    /**
     * Info:
     * View에 대한 제어가 필요한 것임에도 setRecyclerView()는 getAllTodoList()안에서 수행되고 있음.
     * getAllTodoList()는 메인 스레드가 아닌 Thread에서 실행되고 있기 때문에 View에 대한 제어가 불가능하다.(왜냐하면 View는 중요한 요소로 메인 Thread에서만 돌아가기 때문)
     * 따라서 runOnUiThread 모듈을 사용해서 구현해야 함.
     */
    private fun setRecyclerView() {
        runOnUiThread {
            adapter = TodoRecyclerViewAdapter(todoList)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onRestart(){
        super.onRestart()
        getAllTodoList()
    }
}