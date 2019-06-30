package com.example.soccerstats.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import androidx.lifecycle.LiveData;
import com.example.soccerstats.requests.GetDataService;
import com.example.soccerstats.requests.RetrofitClientInstance;
import com.example.soccerstats.db.CompetitionDao;
import com.example.soccerstats.db.SoccerRoomDatabase;
import com.example.soccerstats.model.competition.Competition;
import com.example.soccerstats.model.competition.RequestObject;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompetitionRepository {
  private CompetitionDao mCompetitionDao;
  private LiveData<List<Competition>> mAllCompetitions;
  GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

  public CompetitionRepository(Application application) {
    SoccerRoomDatabase db = SoccerRoomDatabase.getDatabase(application);
    mCompetitionDao = db.competitionDao();
    mAllCompetitions = mCompetitionDao.getAllCompetitions();
  }

  public LiveData<List<Competition>> getAllCompetitions() {
    return mAllCompetitions;
  }

  public void insert() {
    Call<RequestObject> call = service.getRequestObject();
    call.enqueue(new Callback<RequestObject>() {
      @Override
      public void onResponse(Call<RequestObject> call, Response<RequestObject> response) {
        for (Competition c : response.body().getCompetitions()) {
          new insertAsyncTask(mCompetitionDao).execute(c);
        }
      }

      @Override
      public void onFailure(Call<RequestObject> call, Throwable t) {
        Log.i("Request failed", t.getMessage());
      }
    });
  }


  public void insertMatch(String competition) {
    Call<RequestObject> call = service.getMatches(competition);
    call.enqueue(new Callback<RequestObject>() {
      @Override
      public void onResponse(Call<RequestObject> call, Response<RequestObject> response) {
        Log.i("Response", response.toString());
      }

      @Override
      public void onFailure(Call<RequestObject> call, Throwable t) {
        Log.i("Request failed", t.getMessage());
      }
    });
  }

  private static class insertAsyncTask extends AsyncTask<Competition, Void, Void> {
    private CompetitionDao mAsyncTaskDao;

    insertAsyncTask(CompetitionDao dao) {
      mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Competition... params) {
      mAsyncTaskDao.insert(params[0]);
      return null;
    }
  }
}
