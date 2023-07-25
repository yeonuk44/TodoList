package com.example.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Room library 사용 조건

// 1. Entity 사용을 위한 바인딩
@Database(entities = arrayOf(TodoEntity::class), version = 1)

// 2. DB 사용을 위한 바인딩 및 추상화 작업
abstract class AppDatabase : RoomDatabase(){

    // 조회라는 행위를 사용하기 위한 TodoDao  바인딩
    abstract fun getTodoDao() : TodoDao

    companion object{
        val databaseName = "db_todo"
        var appDatabase : AppDatabase ?= null

        fun getInstance(context: Context) : AppDatabase? {
            if(appDatabase == null){
                appDatabase = Room.databaseBuilder(context,
                AppDatabase::class.java,
                databaseName).fallbackToDestructiveMigration().build()
            }
            return appDatabase
        }
    }
}