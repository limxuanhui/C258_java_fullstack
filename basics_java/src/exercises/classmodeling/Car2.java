package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class Car2 {

    private String make;
    private String model;
    private String driverName;
    private float acceleration;
    private float topSpeed;
    private float easeOfHandle;
    private float braking;

    public Car2(String make, String model, String driverName, float acceleration, float topSpeed, float easeOfHandle, float braking) {
        this.make = make;
        this.model = model;
        this.driverName = driverName;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
        this.easeOfHandle = easeOfHandle;
        this.braking = braking;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getEaseOfHandle() {
        return easeOfHandle;
    }

    public void setEaseOfHandle(float easeOfHandle) {
        this.easeOfHandle = easeOfHandle;
    }

    public float getBraking() {
        return braking;
    }

    public void setBraking(float braking) {
        this.braking = braking;
    }
}
