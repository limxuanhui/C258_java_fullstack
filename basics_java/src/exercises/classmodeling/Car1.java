package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class Car1 {

    private String make;
    private String model;
    private float price;
    private String inventoryId;

    public Car1(String make, String model, float price, String inventoryId) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.inventoryId = inventoryId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
}
