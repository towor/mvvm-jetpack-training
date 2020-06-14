package io.github.towor.mvvmjetpacktraining.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.towor.mvvmjetpacktraining.data.Memo

@Dao
interface MemoDao {
    @Query("select * from memo_table")
    fun getAllMemo(): LiveData<List<Memo>>

    @Insert
    suspend fun insert(memo: Memo)

    @Query("delete from memo_table")
    suspend fun deleteAll()
}