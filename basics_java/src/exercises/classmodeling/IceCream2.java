package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class IceCream2 {

    private String brand;
    private String flavour;
    private float price;
    private float batchPrice;

    public IceCream2(String brand, String flavour, float price, float batchPrice) {
        this.brand = brand;
        this.flavour = flavour;
        this.price = price;
        this.batchPrice = batchPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getBatchPrice() {
        return batchPrice;
    }

    public void setBatchPrice(float batchPrice) {
        this.batchPrice = batchPrice;
    }
}
