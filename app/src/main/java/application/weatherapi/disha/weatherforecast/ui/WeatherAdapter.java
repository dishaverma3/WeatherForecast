package application.weatherapi.disha.weatherforecast.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import application.weatherapi.disha.weatherforecast.R;
import application.weatherapi.disha.weatherforecast.model.WeatherDays;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    List<WeatherDays> list;
    Context context;

    public WeatherAdapter(List<WeatherDays> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_weather,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView dayName, temp;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayName = itemView.findViewById(R.id.dayName);
            temp = itemView.findViewById(R.id.temp);
            icon = itemView.findViewById(R.id.icon);
        }

        public void bind(int position){
            WeatherDays listItem = list.get(position);

        }
    }
}
