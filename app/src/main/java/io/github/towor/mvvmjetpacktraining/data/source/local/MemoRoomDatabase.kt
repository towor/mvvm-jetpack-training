package io.github.towor.mvvmjetpacktraining.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.github.towor.mvvmjetpacktraining.data.Memo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Memo::class], version = 1)
abstract class MemoRoomDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        @Volatile
        private var INSTANCE: MemoRoomDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): MemoRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoRoomDatabase::class.java,
                        "memo_database"
                    ).addCallback(MemoDatabaseCallback(scope)).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private class MemoDatabaseCallback(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch {
                    populateData(it.memoDao())
                }
            }
        }

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //初回起動時のみデータ投入したい場合はこっち使う
        }

        suspend fun populateData(memoDao: MemoDao) {
            memoDao.deleteAll()

            var memo = Memo(id = 0, memo = "memo01")
            memoDao.insert(memo)
            memo = Memo(id = 0, memo = "memo02")
            memoDao.insert(memo)
            memo = Memo(id = 0, memo = "memo03")
            memoDao.insert(memo)
        }
    }
}