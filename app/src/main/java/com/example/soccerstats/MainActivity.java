package com.example.soccerstats;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccerstats.model.competition.Competition;
import com.example.soccerstats.viewmodel.CompetitionViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private CompetitionViewModel competitionViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final CompetitionAdapter adapter = new CompetitionAdapter(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    competitionViewModel = ViewModelProviders.of(this).get(CompetitionViewModel.class);

    competitionViewModel.insert();
    //competitionViewModel.insertMatch("2080");

    competitionViewModel.getAllCompetitions().observe(this, new Observer<List<Competition>>() {

          @Override
          public void onChanged(List<Competition> competitions) {
            adapter.setCompetitions(competitions);
          }
        }
    );

  }
}
