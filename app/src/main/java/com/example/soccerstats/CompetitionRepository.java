package com.example.soccerstats;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.soccerstats.db.CompetitionDao;
import com.example.soccerstats.db.SoccerRoomDatabase;
import com.example.soccerstats.model.Competition;
import java.util.List;

public class CompetitionRepository {
  private CompetitionDao mCompetitionDao;
  private LiveData<List<Competition>> mAllCompetitions;

  public CompetitionRepository(Application application) {
    SoccerRoomDatabase db = SoccerRoomDatabase.getDatabase(application);
    mCompetitionDao = db.competitionDao();
    mAllCompetitions = mCompetitionDao.getAllCompetitions();
  }

  public LiveData<List<Competition>> getAllCompetitions() {
    return mAllCompetitions;
  }

  public void insert(Competition competition)  {
    new insertAsyncTask(mCompetitionDao).execute(competition);
  }

  private static class insertAsyncTask extends AsyncTask<Competition, Void, Void> {
    private CompetitionDao mAsyncTaskDao;

    insertAsyncTask(CompetitionDao dao) {
      mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(Competition... competitions) {
      mAsyncTaskDao.insert(competitions[0]);
      return null;
    }
  }
}
