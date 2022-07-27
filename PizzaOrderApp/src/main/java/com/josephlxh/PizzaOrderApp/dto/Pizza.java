package com.josephlxh.PizzaOrderApp.dto;
/* Created by limxuanhui on 30/6/22 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pizza {
    @Id
    @GeneratedValue
    private Integer pizzaId;
    @Column
    private String flavour;
    @Column
    private float price;

    Pizza() {
    }

    Pizza(String flavour, float price) {
        this.flavour = flavour;
        this.price = price;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
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

    @Override
    public String toString() {
        return "Pizza{" +
                "flavour='" + flavour + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Float.compare(pizza.price, price) == 0 && Objects.equals(flavour, pizza.flavour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavour, price);
    }
}
