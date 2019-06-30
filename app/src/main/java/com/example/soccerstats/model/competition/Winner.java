package com.example.soccerstats.model.competition;

public class Winner {
  private String id;
  private String name;
  private String shortName;
  private String tla;
  private String crestUrl;

  public Winner(String id, String name, String shortName, String tla, String crestUrl) {
    this.id = id;
    this.name = name;
    this.shortName = shortName;
    this.tla = tla;
    this.crestUrl = crestUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getTla() {
    return tla;
  }

  public void setTla(String tla) {
    this.tla = tla;
  }

  public String getCrestUrl() {
    return crestUrl;
  }

  public void setCrestUrl(String crestUrl) {
    this.crestUrl = crestUrl;
  }
}
