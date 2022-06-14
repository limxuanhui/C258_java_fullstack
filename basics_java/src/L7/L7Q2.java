package L7;
/* Created by limxuanhui on 14/6/22 */

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.id == student.getId() && this.name == student.getName();
    }

    @Override
    public int hashCode() {
        int nameHash = 1;
        for (int i = 0; i < this.getName().length(); i++) {
            nameHash *= this.getName().charAt(i);
        }
        return this.getId() * nameHash;
    }

}

public class L7Q2 {
    /*
      2) Implement any algorithm of your choice
         for hashcode implementation.
     */

    public static void main(String[] args) {
        Person p1 = new Person(1001, "John");
        Person p2 = new Person(1001, "John");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));
        System.out.println(p1 == p2);
    }
}
