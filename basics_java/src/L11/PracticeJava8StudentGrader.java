package L11;
/* Created by limxuanhui on 20/6/22 */

import java.util.ArrayList;
import java.util.stream.Collectors;

class School {
    private String name;
    private ArrayList<Student> students;
    private final ArrayList<Student> expelledStudents;
    private static int lastStudentId = 0;

    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.expelledStudents = new ArrayList<>();
    }

    School(String name, ArrayList<Student> students) {
        this(name);
        this.students = students;
    }

    public void enrol(Student student) {
        ArrayList<Student> filteredStudents = this.expelledStudents.stream().filter(s -> s.getStudentId() == student.getStudentId())
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredStudents.size() > 0) {
            System.out.println("Sorry you cannot enrol after getting expelled.");
            return;
        }
//        for (Student expelledStudent : this.expelledStudents) {
//            if (expelledStudent.getStudentId() == student.getStudentId()) {
//                System.out.println("Sorry you cannot enrol after getting expelled.");
//                return;
//            }
//        }
        int newStudentId = ++lastStudentId;
        this.students.add(student);
        student.setStudentId(newStudentId);
        System.out.println(student.getName() + " is successfully enrolled with student id " + newStudentId);
    }

    public void expel(Student student) {
        if (student.getGrade() == 'F') {
            this.students.remove(student);
            this.expelledStudents.add(student);
        } else {
            System.out.println("This student has good grades. Cannot be expelled.");
        }
    }

    public void getResults(Student student) {
        System.out.println("===== " + student.getName() + " results slip =====");
        System.out.println("Physics marks: " + student.getPhysicsMarks());
        System.out.println("Chemistry marks: " + student.getChemistryMarks());
        System.out.println("Biology marks: " + student.getBiologyMarks());
        System.out.println("Mathematics marks: " + student.getMathMarks());
        System.out.println("--- Total marks: " + student.getTotalMarks());
        System.out.println("--- Average marks: " + student.getAverageMarks());
        System.out.println("--- Final grade: " + student.getGrade());
    }
}

class Student {
    private String name;
    private int studentId;
    private float physicsMarks;
    private float chemistryMarks;
    private float biologyMarks;
    private float mathMarks;

    public Student(String name, float physicsMarks, float chemistryMarks, float biologyMarks, float mathMarks) {
        this.name = name;
        this.physicsMarks = physicsMarks > 100 ? 100 : physicsMarks;
        this.chemistryMarks = chemistryMarks > 100 ? 100 : chemistryMarks;
        this.biologyMarks = biologyMarks > 100 ? 100 : biologyMarks;
        this.mathMarks = mathMarks > 100 ? 100 : mathMarks;
    }

    public String getName() {
        return this.name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public float getTotalMarks() {
        float totalMarks = this.physicsMarks + this.chemistryMarks + this.biologyMarks + this.mathMarks;
        return totalMarks;
    }

    public float getAverageMarks() {
        float averageMarks = this.getTotalMarks()/4;
        return averageMarks;
    }

    public char getGrade() {
        float averageMarks = this.getAverageMarks();
        if (averageMarks > 90) {
            return 'A';
        } else if (averageMarks > 80) {
            return 'B';
        } else if (averageMarks > 70) {
            return 'C';
        }
        else {
            return 'F';
        }
    }

    public float getPhysicsMarks() {
        return this.physicsMarks;
    }

    public float getChemistryMarks() {
        return this.chemistryMarks;
    }

    public float getBiologyMarks() {
        return this.biologyMarks;
    }

    public float getMathMarks() {
        return this.mathMarks;
    }
}

public class PracticeJava8StudentGrader {
    /*
      1) Student grader
    */

    public static void main(String[] args) {
        Student student1 = new Student("Adam", 90, 80, 90, 100);
        Student student2 = new Student("Bob", 70, 80, 90, 40);
        Student student3 = new Student("Chris", 80, 99, 90, 100);
        Student student4 = new Student("David", 70, 80, 70, 70);
        School school = new School("good school");

//        ArrayList<Student> studentsArrayList = new ArrayList<>();
//        studentsArrayList.add(student1);
//        studentsArrayList.add(student2);
//        studentsArrayList.add(student3);
//        studentsArrayList.add(student4);


        school.getResults(student1);
        school.getResults(student2);
        school.getResults(student3);
        school.getResults(student4);

        school.enrol(student1);
        school.enrol(student2);
        school.enrol(student3);
        school.enrol(student4);
        school.expel(student1);
        school.expel(student2);
        school.expel(student3);
        school.expel(student4);

        // fails because student2 was expelled before
        school.enrol(student2);
    }
}
