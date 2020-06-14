package io.github.towor.mvvmjetpacktraining.data.source.local

import androidx.lifecycle.LiveData
import io.github.towor.mvvmjetpacktraining.data.Memo
import io.github.towor.mvvmjetpacktraining.data.source.MemoDataSource

class MemoLocalDataSource(val memoDao: MemoDao) :MemoDataSource{
    override fun getAllMemo():LiveData<List<Memo>> {
        return memoDao.getAllMemo()
    }

    override suspend fun insert(memo: Memo) {
        memoDao.insert(memo)
    }

    override suspend fun deleteAll() {
        memoDao.deleteAll()
    }

}