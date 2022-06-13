package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class IceCream1 {

    private String brand;
    private String flavour;
    private float price;
    private float volume;

    public IceCream1(String brand, String flavour, float price, float volume) {
        this.brand = brand;
        this.flavour = flavour;
        this.price = price;
        this.volume = volume;
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

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}
