package L7;
/* Created by limxuanhui on 14/6/22 */

import java.util.Objects;

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this.getId() == ((Person)o).getId() && this.getName() == ((Person)o).getName()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class L7Q1 {
    /*
      1) Use both id and name to decide two objects are
         equal to each other or not.
     */

    public static void main(String[] args) {
        Person p1 = new Person(101, "Joe");
        Person p2 = new Person(101, "Joe");
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
