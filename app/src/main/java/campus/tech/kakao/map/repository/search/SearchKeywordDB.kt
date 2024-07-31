package campus.tech.kakao.map.repository.search

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import campus.tech.kakao.map.model.search.SearchKeyword
import campus.tech.kakao.map.model.search.SearchKeywordDao
import kotlinx.coroutines.coroutineScope

@Database(entities = [SearchKeyword::class], version = 1)
abstract class SearchKeywordDB : RoomDatabase() {
    abstract fun searchKeywordDao(): SearchKeywordDao
}