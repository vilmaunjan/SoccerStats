package com.example.soccerstats.model.competition;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "competition_table")
public class Competition {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "id")
  private String id;

  @Embedded(prefix = "area")
  //@ColumnInfo(name = "area")
  private Area area;

  @ColumnInfo(name = "name")
  private String name;

  @ColumnInfo(name = "code")
  private String code;

  @ColumnInfo(name = "emblemUrl")
  private String emblemUrl;

  @ColumnInfo(name = "plan")
  private String plan;

  @Embedded(prefix = "currentSeason")
  private CurrentSeason currentSeason;

  @ColumnInfo(name = "numberOfAvailableSeasons")
  private String numberOfAvailableSeasons;

  @ColumnInfo(name = "lastUpdated")
  private String lastUpdated;

  public Competition(@NonNull String id, Area area, String name, String code,
      String emblemUrl, String plan, CurrentSeason currentSeason,
      String numberOfAvailableSeasons, String lastUpdated) {
    this.id = id;
    this.area = area;
    this.name = name;
    this.code = code;
    this.emblemUrl = emblemUrl;
    this.plan = plan;
    this.currentSeason = currentSeason;
    this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    this.lastUpdated = lastUpdated;
  }

  @NonNull public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getEmblemUrl() {
    return emblemUrl;
  }

  public void setEmblemUrl(String emblemUrl) {
    this.emblemUrl = emblemUrl;
  }

  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public CurrentSeason getCurrentSeason() {
    return currentSeason;
  }

  public void setCurrentSeason(CurrentSeason currentSeason) {
    this.currentSeason = currentSeason;
  }

  public String getNumberOfAvailableSeasons() {
    return numberOfAvailableSeasons;
  }

  public void setNumberOfAvailableSeasons(String numberOfAvailableSeasons) {
    this.numberOfAvailableSeasons = numberOfAvailableSeasons;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
