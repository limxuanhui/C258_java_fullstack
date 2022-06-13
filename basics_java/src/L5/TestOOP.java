package L5;
/* Created by limxuanhui on 10/6/22 */

class Student {
    private int rollNum;
    private String name;
    private int marks;

    // Overloading constructor with parameterised constructor
    // difference is number of parameters and type of parameters
    Student() {

    }

    Student(int rollNum, String name) {
        this.rollNum = rollNum;
        this.name = name;
    }

    // Parameterised constructor
    Student(int rollNum, String name, int marks) {
        this(rollNum, name);
        this.marks = marks;
    }

    public void myIntro() {
        System.out.println("Hey this is " + this.name + ", and my id is " + this.rollNum);
        System.out.println("I scored " + this.marks);
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

public class TestOOP {

    public static void main(String[] args) {
        Student s1 = new Student(101, "Jo", 80);
        s1.myIntro();

        Student s2 = new Student(102, "Jack");
        s2.myIntro();
    }
}
