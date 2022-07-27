package org.example;
/* Created by limxuanhui on 27/6/22 */

import java.util.ArrayList;

class School {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Student> expelledStudents;
    private static int lastStudentId;

    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.expelledStudents = new ArrayList<>();
        this.lastStudentId = 0;
    }

    School(String name, ArrayList<Student> students) {
        this(name);
        this.students = students;
    }

    public void enrol(Student student) {
        for (Student expelledStudent : this.expelledStudents) {
            if (expelledStudent.getStudentId() == student.getStudentId()) {
                System.out.println("Sorry you cannot enrol after getting expelled.");
                return;
            }
        }
        int newStudentId = ++this.lastStudentId;
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

    public float getYearAverage() {
        float sum = this.students.stream()
                .map(s -> s.getAverageMarks())
                .reduce((m1, m2) -> m1 + m2).get();
        float avg = sum / this.students.size();
        return avg;
    }

    public Student getTopScorer() {
        float topScore = this.students.stream()
                .map(s -> s.getTotalMarks())
                .reduce((m1,m2) -> m1 > m2 ? m1 : m2).get();
        Student topScorer = this.students.stream()
                .filter(s -> s.getTotalMarks() == topScore)
                .findFirst()
                .get();
        return topScorer;
    }

    public Student getLowestScorer() {
        float lowestScore = this.students.stream()
                .map(Student::getTotalMarks)
                .reduce((m1,m2) -> m1 < m2 ? m1 : m2)
                .get();
        Student lowestScorer = this.students.stream()
                .filter(s -> s.getTotalMarks() == lowestScore)
                .findFirst()
                .get();
        return lowestScorer;
    }

    public Student getMathLowestScorer() {
        float lowestScore = this.students.stream()
                .map(Student::getMathMarks)
                .reduce((m1,m2) -> m1 < m2 ? m1 : m2)
                .get();
        Student lowestScorer = this.students.stream()
                .filter(s -> s.getMathMarks() == lowestScore)
                .findFirst()
                .get();
        return lowestScorer;
    }
}
