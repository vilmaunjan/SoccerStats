package com.example.soccerstats.db;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.soccerstats.model.competition.Competition;
import io.reactivex.annotations.NonNull;

@Database(entities = { Competition.class}, version = 3, exportSchema = false)
public abstract class SoccerRoomDatabase extends RoomDatabase {

  public abstract CompetitionDao competitionDao();
  private static SoccerRoomDatabase INSTANCE;

  private static RoomDatabase.Callback sRoomDatabaseCallback =
      new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
          super.onOpen(db);
          new PopulateDbAsync(INSTANCE).execute();
        }
      };

  public static SoccerRoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (SoccerRoomDatabase.class) {
        if (INSTANCE == null) {
          //Create database here
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              SoccerRoomDatabase.class, "soccer_database")
              .fallbackToDestructiveMigration()
              .addCallback(sRoomDatabaseCallback)
              .build();
        }
      }
    }
    return INSTANCE;
  }

  /**
   * Populate the database in the background.
   */
  private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final CompetitionDao mDao;
    String[] competitions = {"comp1", "comp2", "comp3"};

    PopulateDbAsync(SoccerRoomDatabase db) {
      mDao = db.competitionDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
      // Start the app with a clean database every time.
      // Not needed if you only populate the database
      // when it is first created
      //mDao.deleteAll();
      //
      //for (int i = 0; i <= competitions.length - 1; i++) {
      //  Competition competition = new Competition(competitions[i]);
      //  mDao.insert(competition);
      //}
      return null;
    }
  }
}
