package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Date.*;

import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.loc_off;
import static com.example.android.quakereport.R.id.mag;

/**
 * Created by Mustafa Hussain on 06-08-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter (Context context, ArrayList<Earthquake> earthquakes){
        super(context,0, earthquakes);
    }

        private int getMagnitudeColor(double magnitude){
        int mag = (int) Math.floor(magnitude);
        int magnitude1Color;
        switch(mag){
            case 0:
            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10);
                break;
            default:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10);
                break;


        }
        return magnitude1Color;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list,parent,false);
        }
        Earthquake currentItem = getItem(position);

        Date dateObject = new Date(currentItem.getDate());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        String Location = currentItem.getLocation();
        String primaryLocation;
        String locationOffset;
        if(Location.contains("of")) {
            String[] loc_arr = Location.split("of");
            primaryLocation = loc_arr[0] + "of";
            locationOffset = loc_arr[1];
        }
        else{
            primaryLocation = getContext().getString(R.string.near_the);
            locationOffset = Location;
        }

        double Magnitude = currentItem.getMagnitude();
        DecimalFormat magf = new DecimalFormat("0.0");
        String magn=magf.format(Magnitude);




        TextView mag= (TextView) listItemView.findViewById(R.id.mag);
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        int magnitudeColor = getMagnitudeColor(currentItem.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        mag.setText(magn);

        TextView loc_off= (TextView) listItemView.findViewById(R.id.loc_off);
        loc_off.setText(primaryLocation);

        TextView pri_loc= (TextView) listItemView.findViewById(R.id.primary_loc);
        pri_loc.setText(locationOffset);

        TextView date= (TextView) listItemView.findViewById(R.id.date);
        date.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formattedTime);

        return listItemView;
    }
}
