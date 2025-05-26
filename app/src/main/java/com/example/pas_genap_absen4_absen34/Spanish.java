package com.example.pas_genap_absen4_absen34;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Spanish extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout english,spanish,countries,profile;

    private RecyclerView recyclerView;
    private SpanishTeamAdapter adapter;
    private List<SpanishTeam> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spanish);

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        spanish = findViewById(R.id.spanish);
        english = findViewById(R.id.english);
        countries = findViewById(R.id.countries);
        profile = findViewById(R.id.profile);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SpanishTeamAdapter(teamList);
        recyclerView.setAdapter(adapter);

        fetchTeams();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);

            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Spanish.this, MainActivity.class);

            }
        });
        spanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Spanish.this, Countries.class);
            }
        });

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

    private void fetchTeams() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<SpanishTeamResponse> call = apiService.getTeams("Soccer", "Spain");
        call.enqueue(new Callback<SpanishTeamResponse>() {
            @Override
            public void onResponse(Call<SpanishTeamResponse> call, Response<SpanishTeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    teamList.clear();
                    teamList.addAll(response.body().getTeams());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<SpanishTeamResponse> call, Throwable t) {
            }
        });
    }

}