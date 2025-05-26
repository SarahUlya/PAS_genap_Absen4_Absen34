package com.example.pas_genap_absen4_absen34;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpanishTeamResponse {
    @SerializedName("teams")
    private List<SpanishTeam> teams;

    public List<SpanishTeam> getTeams() {
        return teams;
    }
}
