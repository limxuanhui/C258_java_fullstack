package com.josephlxh.PizzaOrderApp.dto;
/* Created by limxuanhui on 30/6/22 */

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue
    private Integer customerId;
    @Column
    private String name;
    @Column
    private String contactNumber;

    public Customer() {
    }

    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(name, customer.name) && Objects.equals(contactNumber, customer.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, contactNumber);
    }
}
