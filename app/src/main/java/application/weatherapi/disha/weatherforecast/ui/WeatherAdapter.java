package application.weatherapi.disha.weatherforecast.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import application.weatherapi.disha.weatherforecast.R;
import application.weatherapi.disha.weatherforecast.model.current.WeatherDays;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    List<WeatherDays> list;
    Context context;
    String imageUrl = "http://openweathermap.org/img/wn/";

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
        View line;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayName = itemView.findViewById(R.id.dayName);
            temp = itemView.findViewById(R.id.temp);
            icon = itemView.findViewById(R.id.icon);
            line = itemView.findViewById(R.id.viewLine);
        }

        public void bind(int position){
            WeatherDays listItem = list.get(position);
            int day = 0;
            String[] weekDays = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};

            String url = imageUrl+listItem.getIcon()+".png";

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {

                Log.d("Weather Forecast" , "bind: RESPONSE TEST -- "+listItem.getDayName());

                Date date = format.parse(listItem.getDayName());

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                day = cal.get(Calendar.DAY_OF_WEEK)-1;
                dayName.setText(weekDays[day]);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            Glide.with(context.getApplicationContext()).load(url).into(icon);
            temp.setText(listItem.getTemp());

            if(position == (getItemCount()-1))
            {
                line.setVisibility(View.GONE);
            }
        }
    }
}
