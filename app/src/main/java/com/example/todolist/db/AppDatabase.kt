package com.example.todolist.db

import androidx.room.Database

// Room library
@Database(entities = arrayOf(TodoEntity::class), version = 1)
class AppDatabase {
}