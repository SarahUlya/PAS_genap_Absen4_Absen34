package com.example.pas_genap_absen4_absen34;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("all_countries.php")
    Call<CountryResponse> getAll_countries();

    @GET("search_all_teams.php")

    Call<TeamsResponse> getTeamsByLeague(@Query("l") String league);
    Call<SpanishTeamResponse> getTeams(
            @Query("s") String sport,
            @Query("c") String country
    );
}




