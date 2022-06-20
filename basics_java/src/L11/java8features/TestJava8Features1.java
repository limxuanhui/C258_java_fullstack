package L11.java8features;
/* Created by limxuanhui on 20/6/22 */

import java.util.*;

class Student4 {
    private int id;
    private String name;

    public Student4(int id, String name) {
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
        Student4 student = (Student4) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class MyStudentComparator implements Comparator<Student4> {

    @Override
    public int compare(Student4 o1, Student4 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class TestJava8Features1 {
    public static void main(String[] args) {
        ArrayList<Student4> mylist = new ArrayList<>();
        mylist.add(new Student4(3, "Jim"));
        mylist.add(new Student4(1, "John"));
        mylist.add(new Student4(4, "Jennie"));
        mylist.add(new Student4(5, "Jacob"));
        mylist.add(new Student4(2, "Jack"));

        System.out.println(mylist);
        Collections.sort(mylist, new MyStudentComparator());
        Collections.sort(mylist, (Student4 o1, Student4 o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        System.out.println(mylist);
    }
}
