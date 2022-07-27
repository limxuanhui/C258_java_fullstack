package com.josephlxh.PizzaOrderApp.dto;
/* Created by limxuanhui on 30/6/22 */

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="porder")
public class Porder {
    @Id
    @GeneratedValue
    private Integer porderId;
    @Column
    private Integer customerId;

    public int getPorderId() {
        return porderId;
    }

    public void setPorderId(int porderId) {
        this.porderId = porderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Porder{" +
                "porderId=" + porderId +
                ", customerId=" + customerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Porder porder = (Porder) o;
        return porderId == porder.porderId && customerId == porder.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(porderId, customerId);
    }
}
