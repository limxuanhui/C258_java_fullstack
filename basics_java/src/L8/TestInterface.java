package L8;
/* Created by limxuanhui on 15/6/22 */

interface Vehicle {
    void moveForward(int milesPerHour);
    void moveBackward(int milesPerHour);
    void stop();
    void turnLeft();
    void turnRight();
    void engineOn();
    void engineOff();
}

interface Trackable {
    void sendCurrentLocation();
    void beaconOn();
    void beaconOff();
}

interface EmergencyVehicle extends Vehicle {
    public void flashersOn();
    public void flashersOff();
    public void sirenOn();
    public void sirenOff();
}

class MidSizeSedan implements Vehicle, Trackable {
    @Override
    public void moveForward(int milesPerHour) {
        // implementation code here...
    }

    @Override
    public void moveBackward(int milesPerHour) {
        // implementation code here...
    }

    @Override
    public void stop() {
        // implementation code here...
    }

    @Override
    public void turnLeft() {
        // implementation code here...
    }

    @Override
    public void turnRight() {
        // implementation code here...
    }

    @Override
    public void engineOn() {
        // implementation code here...
    }

    @Override
    public void engineOff() {
        // implementation code here...
    }

    @Override
    public void sendCurrentLocation() {

    }

    @Override
    public void beaconOn() {

    }

    @Override
    public void beaconOff() {

    }
}

class Ambulance implements EmergencyVehicle {
    @Override
    public void flashersOn() {
        // implementation code here...
    }

    @Override
    public void flashersOff() {
        // implementation code here...
    }

    @Override
    public void sirenOn() {
        // implementation code here...
    }

    @Override
    public void sirenOff() {
        // implementation code here...
    }

    @Override
    public void moveForward(int milesPerHour) {
        // implementation code here...
    }

    @Override
    public void moveBackward(int milesPerHour) {
        // implementation code here...
    }

    @Override
    public void stop() {
        // implementation code here...
    }

    @Override
    public void turnLeft() {
        // implementation code here...
    }

    @Override
    public void turnRight() {
        // implementation code here...
    }

    @Override
    public void engineOn() {
        // implementation code here...
    }

    @Override
    public void engineOff() {
        // implementation code here...
    }
}

public class TestInterface {

    public static void main(String[] args) {
        MidSizeSedan midSizeSedan = new MidSizeSedan();
        Vehicle midSizeSedanVehicle = new MidSizeSedan();

        midSizeSedan.sendCurrentLocation();
        // midSizeSedanVehicle does not have Trackable methods
    }
}

