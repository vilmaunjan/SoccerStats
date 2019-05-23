package com.example.soccerstats.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "competition_table")
public class Competition {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "competition")
  private String id;

  public Competition(@NonNull String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }
}
