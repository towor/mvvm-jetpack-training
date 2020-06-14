package io.github.towor.mvvmjetpacktraining.data.source

import androidx.lifecycle.LiveData
import io.github.towor.mvvmjetpacktraining.data.Memo

interface MemoDataSource {
    fun getAllMemo(): LiveData<List<Memo>>

    suspend fun insert(memo: Memo)

    suspend fun deleteAll()
}