package com.example.soccerstats.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.soccerstats.model.Competition;

@Database(entities = { Competition.class}, version = 1, exportSchema = false)
public abstract class SoccerRoomDatabase extends RoomDatabase {

  public abstract CompetitionDao competitionDao();
  private static SoccerRoomDatabase INSTANCE;

  public static SoccerRoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (SoccerRoomDatabase.class) {
        if (INSTANCE == null) {
          //Create database here
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              SoccerRoomDatabase.class, "soccer_database")
              .fallbackToDestructiveMigration()
              .build();
        }
      }
    }
    return INSTANCE;
  }
}
