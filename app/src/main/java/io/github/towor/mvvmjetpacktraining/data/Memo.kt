package io.github.towor.mvvmjetpacktraining.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo_table")
class Memo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "memo") val memo: String)