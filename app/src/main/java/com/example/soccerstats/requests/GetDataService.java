package com.example.soccerstats.requests;

import com.example.soccerstats.Constants;
import com.example.soccerstats.model.competition.Competition;
import com.example.soccerstats.model.competition.RequestObject;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GetDataService {

  @Headers("X-Auth-Token: "+ Constants.API_KEY)
  @GET("/v2/competitions")
  Call<List<Competition>> getCompetitions();

  @Headers("X-Auth-Token:"+ Constants.API_KEY)
  @GET("/v2/competitions")
  Call<RequestObject> getRequestObject();

  @Headers("X-Auth-Token:"+ Constants.API_KEY)
  @GET("/v2/competitions/{competitionId}/matches")
  Call<RequestObject> getMatches(@Path("competitionId") String competitionId);

  //Sports API
  @Headers("X-Auth-Token:"+ Constants.API_KEY)
  @GET("/v2/competitions")
  Call<RequestObject> getSportRequestObject();

}
