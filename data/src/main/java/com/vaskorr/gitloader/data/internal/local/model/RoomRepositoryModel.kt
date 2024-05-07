package com.vaskorr.gitloader.data.internal.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class Repository(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "label") val label: String,
    @ColumnInfo(name = "owner") val owner: String,
    @ColumnInfo(name = "uri") val uri: String,
    @ColumnInfo(name = "url") val url: String
)