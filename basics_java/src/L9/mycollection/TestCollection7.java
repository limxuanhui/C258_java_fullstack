package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.*;

class Student3 {
    private int id;
    private String name;

    public Student3(int id, String name) {
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
        return "Student3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Student equals method called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student3 student = (Student3) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class MyStudentComparator implements Comparator<Student3> {

    @Override
    public int compare(Student3 o1, Student3 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

// Difference between comparator and comparable
public class TestCollection7 {
    public static void main(String[] args) {
        Student3 s1 = new Student3(101, "a");
        Student3 s2 = new Student3(102, "b");
        Student3 s3 = new Student3(103, "c");
        Student3 s4 = new Student3(103, "c");
        ArrayList<Student3> students3 = new ArrayList<>();
//        Set<Student3> students3Set = new TreeSet<>();

        students3.add(s3);
        students3.add(s1);
        students3.add(s4);
        students3.add(s2);
        System.out.println(students3);
        Collections.sort(students3, new MyStudentComparator());
        System.out.println(students3);

//        students3Set.add(s3);
//        students3Set.add(s1);
//        students3Set.add(s4);
//        students3Set.add(s2);
//        System.out.println("Student3Set: " + students3Set);
    }
}
