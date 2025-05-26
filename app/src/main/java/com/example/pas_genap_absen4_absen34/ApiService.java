package com.example.pas_genap_absen4_absen34;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("all_countries.php")
    Call<CountryResponse> getAll_countries();

}

