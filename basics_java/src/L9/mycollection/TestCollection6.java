package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.*;

class Student2 implements Comparable<Student2> {
    private int id;
    private String name;

    public Student2(int id, String name) {
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
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Student equals method called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student = (Student2) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // logic for sorting comparison: -1 for <, 0 for ==, 1 for >
    @Override
    public int compareTo(Student2 o) {
        System.out.println("Comparing " + this + " | " + o);
        if (this.getId() >= o.getId()) {
            return 1;
        } else if (this.getId() < o.getId()) {
            return -1;
        } else {
            return 0;
        }
//        return this.getName().compareTo(o.getName());
    }
}

public class TestCollection6 {
    public static void main(String[] args) {
        Student2 s1 = new Student2(101, "a");
        Student2 s2 = new Student2(102, "b");
        Student2 s3 = new Student2(103, "c");
        Student2 s4 = new Student2(103, "c");
//        ArrayList<Student2> students2 = new ArrayList<>();
        Set<Student2> students2Set = new TreeSet<>();

//        students2.add(s3);
//        students2.add(s1);
//        students2.add(s4);
//        students2.add(s2);
//        System.out.println(students2);
//        Collections.sort(students2);
//        System.out.println(students2);

        students2Set.add(s3);
        students2Set.add(s1);
        students2Set.add(s4);
        students2Set.add(s2);
        System.out.println("Student2Set: " + students2Set);

    }
}
