package io.github.towor.mvvmjetpacktraining.data.source

import androidx.lifecycle.LiveData
import io.github.towor.mvvmjetpacktraining.data.Memo
import io.github.towor.mvvmjetpacktraining.data.source.local.MemoDao
import io.github.towor.mvvmjetpacktraining.data.source.local.MemoLocalDataSource

//データ取得先がリモートに変更になった場合は引数をremoteのDataSourceに変更する
class MemoRepository(private val memoLocalDataSource: MemoLocalDataSource): MemoDataSource {
    override fun getAllMemo(): LiveData<List<Memo>> {
        return memoLocalDataSource.getAllMemo()
    }

    override suspend fun insert(memo: Memo) {
        memoLocalDataSource.insert(memo)
    }

    override suspend fun deleteAll() {
        memoLocalDataSource.deleteAll()
    }
}