package com.example.pas_genap_absen4_absen34;

import com.google.gson.annotations.SerializedName;

public class SpanishTeam {

    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("strStadium")
    private String stadium;

    @SerializedName("intFormedYear")
    private String yearEstablished;

    @SerializedName("strTeamBadge")
    private String logoUrl;

    public String getTeamName() { return teamName; }
    public String getStadium() { return stadium; }
    public String getYearEstablished() { return yearEstablished; }
    public String getLogoUrl() { return logoUrl; }
}