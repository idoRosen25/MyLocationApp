package e.idorosenblum.mykalapp.models;

import android.location.Location;

public class MyLocation extends Location{

    private double lat;
    private double lng;

    public MyLocation(String provider,double lat_,double lng_) {
        super(provider);
        lat=lat_;
        lng=lng_;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
