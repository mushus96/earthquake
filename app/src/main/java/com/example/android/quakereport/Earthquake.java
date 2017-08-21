package com.example.android.quakereport;

/**
 * Created by Mustafa Hussain on 06-08-2017.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;
    private String url;

    public Earthquake (double magnitudes,String locations, long dates, String urll){
        magnitude=magnitudes;
        location=locations;
        date=dates;
        url=urll;
    }
    public double getMagnitude(){return magnitude;}
    public String getLocation() {return location;}
    public long getDate(){return date;}
    public String getUrl(){return url;}
}
