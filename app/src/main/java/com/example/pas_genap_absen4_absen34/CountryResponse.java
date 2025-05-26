package com.example.pas_genap_absen4_absen34;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryResponse {
    @SerializedName("countries")
    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }
}
