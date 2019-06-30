package com.example.soccerstats.model.competition;

import androidx.room.Embedded;

public class CurrentSeason {

  private String id;
  private String startDate;
  private String endDate;
  private String currentMatchday;
  @Embedded(prefix = "currentSeason")
  private Winner winner;

  public CurrentSeason(String id, String startDate, String endDate, String currentMatchday,
      Winner winner) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.currentMatchday = currentMatchday;
    this.winner = winner;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getCurrentMatchday() {
    return currentMatchday;
  }

  public void setCurrentMatchday(String currentMatchday) {
    this.currentMatchday = currentMatchday;
  }

  public Winner getWinner() {
    return winner;
  }

  public void setWinner(Winner winner) {
    this.winner = winner;
  }
}
