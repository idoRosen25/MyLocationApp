package e.idorosenblum.mykalapp.models;

import java.io.Serializable;
import java.util.List;


public class LocationModel implements Serializable {

    private String name;
    private String vicinity;
    private Geometry geometry;
    private List<Photo> photos;

    private String mDistance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void setDistance(String s) {
        mDistance = s;
    }

    public String getDistance() {
        return mDistance;
    }
}
