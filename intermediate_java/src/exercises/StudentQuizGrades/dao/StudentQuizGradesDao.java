package exercises.StudentQuizGrades.dao;
/* Created by limxuanhui on 21/6/22 */

import exercises.StudentQuizGrades.dto.Student;

import java.util.List;

/*
  View a list of students in the system
  Add a student to the system
  Remove a student from the system
  View a list of quiz scores for a given student
  View the average quiz score for a given student
*/
public interface StudentQuizGradesDao {
    List<Student> getStudentList() throws StudentQuizGradesDaoException;

    Student addStudent(Student student) throws StudentQuizGradesDaoException;

    Student removeStudent(String name) throws StudentQuizGradesDaoException;

    List<Integer> getQuizScores(String name);

    Float getAverageQuizScore(String name);

    Float getClassAverageQuizScore();

    List<Student> getHighestScorers();

    List<Student> getLowestScorers();
}
