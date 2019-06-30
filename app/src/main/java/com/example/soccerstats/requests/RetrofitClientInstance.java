package com.example.soccerstats.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

  private static Retrofit retrofit;
  private static final String BASE_URL = "https://api.football-data.org/";

  public static Retrofit getRetrofitInstance() {
    if (retrofit == null) {
      retrofit = new retrofit2.Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          //.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
          .build();
    }
    return retrofit;
  }
}
