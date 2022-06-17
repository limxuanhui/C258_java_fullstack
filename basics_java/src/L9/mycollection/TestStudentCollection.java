package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Student equals method called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        System.out.println("Students are equal: " + (id == student.id && Objects.equals(name, student.name)));
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Student hashCode called");
//        return 0;
        return Objects.hash(id, name);
    }
}

public class TestStudentCollection {
    public static void main(String[] args) {
        Set<Student> students = new LinkedHashSet<>();

        System.out.println("Student add called");
        students.add(new Student(101, "a"));
        System.out.println("\t-------101 added\n");

        System.out.println("Student add called");
        students.add(new Student(102, "b"));
        System.out.println("\t-------102 added\n");

        System.out.println("Student add called");
        students.add(new Student(103, "c"));
        System.out.println("\t-------103 added\n");

        System.out.println("Student add called");
        students.add(new Student(103, "c"));
        System.out.println("\t-------103 added again\n");

        System.out.println("Student add called");
        students.add(new Student(101, "a"));
        System.out.println("\t-------101 added again\n");

        System.out.println(students);

//        stack implements list
//        Stack<Integer> s = new Stack<>();
//        s.add(100);
//        s.add(101);
//        s.add(102);
//        System.out.println(s);
//        System.out.println(s.peek());
//        System.out.println(s.get(2));
//        System.out.println(s.get(3));


        ArrayList<Integer> arr = new ArrayList<>(10);
        arr.add(10);
        arr.set(0, 11);
        System.out.println(arr);
    }
}
