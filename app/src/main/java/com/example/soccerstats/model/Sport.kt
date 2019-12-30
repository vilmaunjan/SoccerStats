package com.example.soccerstats.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sport_table")
class Sport {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private var id: String

    @ColumnInfo(name = "name")
    private var name: String

    @ColumnInfo(name = "type")
    private var type: String

    @ColumnInfo(name = "thumbnail")
    private var thumbnail: String

    @ColumnInfo(name = "description")
    private var description: String

    constructor(id: String, name: String, type: String, thumbnail: String, description: String) {
        this.id = id
        this.name = name
        this.type = type
        this.thumbnail = thumbnail
        this.description = description
    }

//    fun getId(): String {
//        return id
//    }
//
//    fun setId(id: String) {
//        this.id = id
//    }

}