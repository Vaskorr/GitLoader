package com.vaskorr.gitloader.data.internal.local.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import com.vaskorr.gitloader.data.internal.local.model.Repository

@Dao
interface RepositoryDao {
    @Query("SELECT * FROM repository")
    fun getAll(): List<Repository>

    @Insert
    fun insert(vararg repository: Repository)

    @Delete
    fun delete(repository: Repository)
}

@Database(entities = [Repository::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
}