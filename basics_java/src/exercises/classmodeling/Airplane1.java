package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class Airplane1 {

    private String name;
    private int seatingCapacity;
    private Passenger[] passengers;

    public Airplane1(String name, int seatingCapacity, Passenger[] passengers) {
        this.name = name;
        this.seatingCapacity = seatingCapacity;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}
