package io.github.towor.mvvmjetpacktraining.memoList

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.towor.mvvmjetpacktraining.data.Memo
import io.github.towor.mvvmjetpacktraining.data.source.MemoRepository
import io.github.towor.mvvmjetpacktraining.data.source.local.MemoLocalDataSource
import io.github.towor.mvvmjetpacktraining.data.source.local.MemoRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MemoRepository

    val allMemos: LiveData<List<Memo>>

    init {
        val memoDao = MemoRoomDatabase.getInstance(application, viewModelScope).memoDao()
        repository = MemoRepository(MemoLocalDataSource(memoDao))
        allMemos = repository.getAllMemo()
    }

    fun insert(memo: Memo){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(memo)
        }
    }
}