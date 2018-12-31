package e.idorosenblum.mykalapp.models;

import java.util.List;

public class Photo {

    private String photo_reference;
    private List<String> html_attributes;
    private int height;
    private int width;

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public List<String> getHtml_attributes() {
        return html_attributes;
    }

    public void setHtml_attributes(List<String> html_attributes) {
        this.html_attributes = html_attributes;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
