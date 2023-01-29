package com.example.weatherapplicationgfg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAdapter  extends RecyclerView.Adapter <WeatherAdapter.ViewHolder>{

    private final Context context;
    private final ArrayList<WeatherRVModel> weatherRVModelArrayList;

    public WeatherAdapter(Context context, ArrayList<WeatherRVModel> weatherRVModelArrayList) {
        this.context = context;
        this.weatherRVModelArrayList = weatherRVModelArrayList;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherRVModel model = weatherRVModelArrayList.get(position);
        holder.temperatureTV.setText(model.getTemperature()+"°c");
        Picasso.get().load("http:".concat(model.getIcon())).into(holder.conditionIV);
        holder.windTV.setText(model.getWindSpeed()+"Km/h");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");
        try{
            Date t = input.parse(model.getTime());
            assert t != null;
            holder.timeTV.setText(output.format(t));
        }catch (ParseException e){
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return weatherRVModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView windTV;
        private final TextView temperatureTV;
        private final TextView timeTV;
        private final ImageView conditionIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            windTV = itemView.findViewById(R.id.idTVWindSpeed);
            temperatureTV = itemView.findViewById(R.id.idTVTemperature) ;
            timeTV = itemView.findViewById(R.id.idTVTime) ;
            conditionIV = itemView.findViewById(R.id.idTVCondition);
        }
    }
}
