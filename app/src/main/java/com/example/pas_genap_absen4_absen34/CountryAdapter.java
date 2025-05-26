package com.example.pas_genap_absen4_absen34;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countryList;

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    public void setCountryList(List<Country> countries) {
        this.countryList = countries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countries, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.tvCountries.setText(country.getName_en());
        Glide.with(holder.itemView.getContext())
                .load(country.getFlag_url_32())
                .into(holder.imgCountries);
    }

    @Override
    public int getItemCount() {
        return countryList == null ? 0 : countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountries;
        ImageView imgCountries;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCountries = itemView.findViewById(R.id.imgCountry);
            tvCountries = itemView.findViewById(R.id.tvCountry);
        }
    }
}


