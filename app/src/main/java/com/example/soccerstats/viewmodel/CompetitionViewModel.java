package com.example.soccerstats.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.soccerstats.repositories.CompetitionRepository;
import com.example.soccerstats.model.competition.Competition;
import java.util.List;

public class CompetitionViewModel extends AndroidViewModel {

  private CompetitionRepository mRepository;
  private LiveData<List<Competition>> mAllCompetitions;

  public CompetitionViewModel(@NonNull Application application) {
    super(application);
    mRepository = new CompetitionRepository(application);
    mAllCompetitions = mRepository.getAllCompetitions();
  }

  public LiveData<List<Competition>> getAllCompetitions() {
    return mAllCompetitions;
  }

  public void insert() {
    mRepository.insert();
  }

  public void insertMatch(String competition) {
    mRepository.insertMatch(competition);
  }

}
