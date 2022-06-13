package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class Airplane2 {

    private String direction;
    private double speed;
    private String latitude;
    private String longitude;
    private double fuelLevel;

    public Airplane2(String direction, double speed, String latitude, String longitude, double fuelLevel) {
        this.direction = direction;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fuelLevel = fuelLevel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
