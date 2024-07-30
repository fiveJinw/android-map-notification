package campus.tech.kakao.map.database

import androidx.room.Database
import androidx.room.RoomDatabase
import campus.tech.kakao.map.model.MapItemEntity

@Database(entities = [MapItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mapItemDao(): MapItemDao
}