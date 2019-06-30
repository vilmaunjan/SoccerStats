package com.example.soccerstats.model.competition;

import com.example.soccerstats.model.competition.Competition;
import java.util.List;

public class RequestObject {

  private List<Competition> competitions;

  public RequestObject(List<Competition> competitions) {
    this.competitions = competitions;
  }

  public List<Competition> getCompetitions() {
    return competitions;
  }

}
