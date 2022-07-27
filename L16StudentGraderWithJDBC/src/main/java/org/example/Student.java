package org.example;
/* Created by limxuanhui on 27/6/22 */

public class Student {
    private String name;
    private int studentId;
    private int physicsMarks;
    private int chemistryMarks;
    private int biologyMarks;
    private int mathMarks;

    public Student(String name, int physicsMarks, int chemistryMarks, int biologyMarks, int mathMarks) {
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

    public int getTotalMarks() {
        int totalMarks = this.physicsMarks + this.chemistryMarks + this.biologyMarks + this.mathMarks;
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

    public int getPhysicsMarks() {
        return this.physicsMarks;
    }

    public int getChemistryMarks() {
        return this.chemistryMarks;
    }

    public int getBiologyMarks() {
        return this.biologyMarks;
    }

    public int getMathMarks() {
        return this.mathMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", physicsMarks=" + physicsMarks +
                ", chemistryMarks=" + chemistryMarks +
                ", biologyMarks=" + biologyMarks +
                ", mathMarks=" + mathMarks +
                ", totalScore=" + getTotalMarks() +
                '}';
    }
}
