package exercises.StudentQuizGrades.dao;
/* Created by limxuanhui on 21/6/22 */

import exercises.StudentQuizGrades.dto.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentQuizGradesDaoFileImpl implements StudentQuizGradesDao {
    private final String DELIMITER = ",";
    private final String STUDENT_QUIZ_GRADES_FILE = "src/exercises/StudentQuizGrades/student_quiz_grades.txt";
    private List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> getStudentList() throws StudentQuizGradesDaoException {
        loadStudentQuizGrades();
        return studentList;
    }

    @Override
    public Student addStudent(Student student) throws StudentQuizGradesDaoException {
        loadStudentQuizGrades();
        studentList.add(student);
        writeStudentQuizGrades();
        return student;
    }

    @Override
    public Student removeStudent(String name) throws StudentQuizGradesDaoException {
        loadStudentQuizGrades();
        List<Student> studentToRemove = studentList.stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
        if (!studentToRemove.isEmpty()) {
            studentList.remove(studentToRemove.get(0));
            writeStudentQuizGrades();
            return studentToRemove.get(0);
        }
        return null;
    }

    @Override
    public List<Integer> getQuizScores(String name) {
        List<Student> student = studentList.stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
        if (!student.isEmpty()) {
            return student.get(0).getQuizScores();
        }
        return null;
    }

    @Override
    public Float getAverageQuizScore(String name) {
        List<Integer> quizScores = getQuizScores(name);
        if (quizScores != null) {
            Integer sum = quizScores.stream().reduce(Integer::sum).get();
            float average = (float) sum / quizScores.size();
            return average;
        }
        return null;
    }

    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMITER);
        List<Integer> quizScores = new ArrayList<>();
        String name = "";
        if (studentTokens.length > 2) {
            name = studentTokens[0];
            for (int i = 1; i < studentTokens.length; i++) {
                quizScores.add(Integer.parseInt(studentTokens[i]));
            }
        }
        return new Student(name, quizScores);
    }

    private void loadStudentQuizGrades() throws StudentQuizGradesDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(STUDENT_QUIZ_GRADES_FILE)));
        } catch (FileNotFoundException e) {
            throw new StudentQuizGradesDaoException("Could not load student quiz grades into memory", e);
        }

        String currentLine;
        Student currentStudent;
        studentList.clear();
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            studentList.add(currentStudent);
        }

        scanner.close();
    }

    private String marshallStudent(Student student) {
        String name = student.getName();
        List<Integer> quizScores = student.getQuizScores();
        StringBuilder studentAsText = new StringBuilder(name);
        for (Integer score : quizScores) {
            studentAsText.append(DELIMITER).append(score);
        }
        return studentAsText.toString();
    }

    private void writeStudentQuizGrades() throws StudentQuizGradesDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(
                    new FileWriter(STUDENT_QUIZ_GRADES_FILE)
            );
        } catch (IOException e) {
            throw new StudentQuizGradesDaoException("Could not save student data", e);
        }

        String studentAsText;
        for (Student student : studentList) {
            studentAsText = marshallStudent(student);
            out.println(studentAsText);
            out.flush();
        }

        out.close();
    }
}
