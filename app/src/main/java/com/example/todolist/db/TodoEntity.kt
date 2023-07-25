package com.example.todolist.db

import androidx.room.ColumnInfo
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// 여기서 Entity는 Annotation으로 자바(코틀린) 코드에 추가할 수 있는 메타데이터의 한 형태로, 매개변수로 사용이 가능합니다.
@Entity
// 해당 코드에선 함수를 사용하지 않기 때문에 중괄호{}를 사용하지 않는다.
data class TodoEntity(
    // @PrimaryKey를 사용하는 것으로 id가 식별가능한 키로 쓰이게 됩니다.
    @PrimaryKey(autoGenerate = true) var id : Int? = null,

    // @ColumnInfo를 사용하는 것으로 데이터 테이블의 column을 정의해줄 수 있습니다.
    @ColumnInfo(name = "title") var title : String,
    @ColumnInfo(name = "importance") var importance: Int
)

