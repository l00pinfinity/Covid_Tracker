package com.boitdroid.covid19.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.boitdroid.covid19.R;
import com.boitdroid.covid19.models.Tracker;

public class TrackerAdapter extends RecyclerView.Adapter<TrackerAdapter.ViewHolder> {

    private final List<Tracker> trackerList;

    public TrackerAdapter(List<Tracker> trackerList) {
        this.trackerList = trackerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mCountryText.setText(trackerList.get(position).getCountryText());
        holder.mLastUpdate.setText(trackerList.get(position).getLastUpdate());
        holder.mTotalCases.setText(trackerList.get(position).getTotalCasesText());
        holder.mActiveCases.setText(trackerList.get(position).getActiveCasesText());
        holder.mTotalDeaths.setText(trackerList.get(position).getTotalDeathsText());
        holder.mNewCases.setText(trackerList.get(position).getNewCasesText());
        holder.mTotalRecovered.setText(trackerList.get(position).getTotalRecoveredText());
        holder.mNewDeaths.setText(trackerList.get(position).getNewDeathsText());
    }

    @Override
    public int getItemCount() {
        return trackerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //initialize our textview
        TextView mCountryText;
        TextView mLastUpdate;
        TextView mTotalCases;
        TextView mActiveCases;
        TextView mTotalDeaths;
        TextView mNewCases;
        TextView mTotalRecovered;
        TextView mNewDeaths;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mCountryText = itemView.findViewById(R.id.CountryText);
            mLastUpdate = itemView.findViewById(R.id.LastUpdate);
            mTotalCases = itemView.findViewById(R.id.TotalCases);
            mActiveCases = itemView.findViewById(R.id.ActiveCases);
            mTotalDeaths = itemView.findViewById(R.id.TotalDeaths);
            mNewCases = itemView.findViewById(R.id.NewCases);
            mTotalRecovered = itemView.findViewById(R.id.TotalRecovered);
            mNewDeaths = itemView.findViewById(R.id.NewDeaths);
        }
    }
}
