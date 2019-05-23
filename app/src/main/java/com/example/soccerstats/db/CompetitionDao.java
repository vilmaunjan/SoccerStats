package com.example.soccerstats.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.soccerstats.model.Competition;
import java.util.List;

@Dao
public interface CompetitionDao {

  @Insert
  void insert(Competition competition);

  @Query("DELETE FROM competition_table")
  void deleteAll();

  @Query("SELECT * from competition_table ORDER BY competition ASC")
  LiveData<List<Competition>> getAllCompetitions();
}
