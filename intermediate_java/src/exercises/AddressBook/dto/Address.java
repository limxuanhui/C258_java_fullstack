package exercises.AddressBook.dto;
/* Created by limxuanhui on 23/6/22 */

import java.util.Objects;

public class Address {
    private String firstName;
    private String lastName;
    private String streetName;
    private String town;
    private String city;
    private String zipCode;

    public Address(String firstName, String lastName, String streetName, String town, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.town = town;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n"
                + streetName + "\n"
                + town + ", " + city + ", " + zipCode + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(firstName, address.firstName) && Objects.equals(lastName, address.lastName) && Objects.equals(streetName, address.streetName) && Objects.equals(town, address.town) && Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, streetName, town, city, zipCode);
    }
}
