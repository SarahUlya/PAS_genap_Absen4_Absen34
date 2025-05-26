package com.example.pas_genap_absen4_absen34;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SpanishTeamAdapter extends RecyclerView.Adapter<SpanishTeamAdapter.ViewHolder> {

    private List<SpanishTeam> teamList;

    public SpanishTeamAdapter(List<SpanishTeam> teamList) {
        this.teamList = teamList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeamName, tvStadium, tvYear;
        ImageView imgLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            tvYear = itemView.findViewById(R.id.tvYear);
            imgLogo = itemView.findViewById(R.id.imgLogo);
        }
    }

    @Override
    public SpanishTeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spanish, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpanishTeamAdapter.ViewHolder holder, int position) {
        SpanishTeam team = teamList.get(position);
        holder.tvTeamName.setText(team.getTeamName());
        holder.tvStadium.setText(team.getStadium());
        holder.tvYear.setText(String.valueOf(team.getYearEstablished()));

        Glide.with(holder.imgLogo.getContext())
                .load(team.getLogoUrl())
                .placeholder(R.drawable.placeholder_logo)
                .error(R.drawable.placeholder_logo)
                .into(holder.imgLogo);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }
}