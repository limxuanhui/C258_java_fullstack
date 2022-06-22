package exercises.StudentQuizGrades;
/* Created by limxuanhui on 21/6/22 */

import exercises.StudentQuizGrades.controller.StudentQuizGradesController;
import exercises.StudentQuizGrades.dao.StudentQuizGradesDao;
import exercises.StudentQuizGrades.dao.StudentQuizGradesDaoFileImpl;
import exercises.StudentQuizGrades.ui.StudentQuizGradesView;
import io.UserIO;
import io.UserIOConsoleImpl;


/*
  View a list of students in the system
  Add a student to the system
  Remove a student from the system
  View a list of quiz scores for a given student
  View the average quiz score for a given student

  Calculate the average quiz score for the entire class.
  Find and list the student(s) with the highest quiz score.
  Find and list the student(s) with the lowest quiz score.
*/
public class StudentQuizGrades {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        StudentQuizGradesView view = new StudentQuizGradesView(io);
        StudentQuizGradesDao dao = new StudentQuizGradesDaoFileImpl();
        StudentQuizGradesController controller = new StudentQuizGradesController(dao, view);
        controller.run();
    }
}
