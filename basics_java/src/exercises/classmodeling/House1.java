package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class House1 {
    private String latitude;
    private String longitude;

    public House1(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void displayLocation() {
        System.out.println("House is at Lat: " + latitude + " Lon: " + longitude);
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
