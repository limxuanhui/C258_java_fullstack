package L7;
/* Created by limxuanhui on 14/6/22 */

class Student {
    private String name;
    private int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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
        System.out.println("Student " + this.getId() + " equals called");
        return this.getId() == ((Student)o).getId() && this.getName() == ((Student)o).getName();
    }

    @Override
    public int hashCode() {
        System.out.println("Student " + this.getId() + " hashCode called");
        int nameHash = 1;
        for (int i = 0; i < this.getName().length(); i++) {
            nameHash *= this.getName().charAt(i);
        }

        return this.getId() + nameHash;
    }
}

public class L7Q2 {
    /*
      2) Implement any algorithm of your choice
         for hashcode implementation.
     */

    public static void main(String[] args) {
        Student s1 = new Student(1001, "John");
        Student s2 = new Student(1001, "John");
//        System.out.println("s1: " + s1);
//        System.out.println("s2: " + s2);
//
        System.out.println(s1.hashCode());
        System.out.println();
        System.out.println(s2.hashCode());

//        System.out.println(s1.equals(s2));
//        System.out.println(s2.equals(s1));
//        System.out.println(s1 == s2);
    }
}
