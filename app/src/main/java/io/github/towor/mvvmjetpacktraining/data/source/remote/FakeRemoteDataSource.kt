package io.github.towor.mvvmjetpacktraining.data.source.remote

import androidx.lifecycle.LiveData
import io.github.towor.mvvmjetpacktraining.data.Memo
import io.github.towor.mvvmjetpacktraining.data.source.MemoDataSource

class FakeRemoteDataSource: MemoDataSource {
    override fun getAllMemo(): LiveData<List<Memo>> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(memo: Memo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

}