package model.dto;
/* Created by limxuanhui on 27/6/22 */

import java.math.BigDecimal;
import java.util.Objects;

public class VendingMachineItem {
    private int index;
    private String name;
    private BigDecimal price;
    private int qty;

    public VendingMachineItem(int index, String name, BigDecimal price, int qty) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.qty = qty > 10 ? 10 : Math.max(qty, 0);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "| " + name + " |\n" + "|(" + (qty > 0 ? index : "X") + ") $" + price + " |";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineItem that = (VendingMachineItem) o;
        return qty == that.qty && Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, qty);
    }
}
