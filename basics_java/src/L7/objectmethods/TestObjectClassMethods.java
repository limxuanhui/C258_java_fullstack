package L7.objectmethods;
/* Created by limxuanhui on 14/6/22 */

// Object class --> parent class of all java classes

import java.util.Objects;

class Person {
    private int ssn; // social security number
    private String name;

    public Person(int ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Person { name: " + name  + ", ssn: " + ssn + " }";
//    }

//    @Override
//    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        Person person = (Person) o;
////        return ssn == person.ssn && Objects.equals(name, person.name);
//        if (this.getName() == ((Person)o).getName() && this.getSsn() == ((Person)o).getSsn()) {
//            return true;
//        }
//        return false;
//    }

    // used for better search performance
    @Override
    public int hashCode() {
        return Objects.hash(ssn, name);
    }
}

public class TestObjectClassMethods {

    public static void main(String[] args) {
        Person p1 = new Person(101, "John");
        Person p2 = new Person(101, "John");
//        System.out.println(p1.equals(p2));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.hashCode());
    }
}
