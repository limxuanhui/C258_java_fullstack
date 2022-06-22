package exercises.StudentQuizGrades.controller;
/* Created by limxuanhui on 21/6/22 */

import exercises.StudentQuizGrades.dao.StudentQuizGradesDao;
import exercises.StudentQuizGrades.dao.StudentQuizGradesDaoException;
import exercises.StudentQuizGrades.dto.Student;
import exercises.StudentQuizGrades.ui.StudentQuizGradesView;

import java.util.List;

public class StudentQuizGradesController {
    private StudentQuizGradesDao dao;
    private StudentQuizGradesView view;

    public StudentQuizGradesController(StudentQuizGradesDao dao, StudentQuizGradesView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        int menuSelection;
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        viewStudentList();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 4:
                        viewStudentQuizScoresList();
                        break;
                    case 5:
                        viewStudentAverageQuizScore();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (StudentQuizGradesDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetMenuSelection();
    }

    private void viewStudentList() throws StudentQuizGradesDaoException {
        view.displayViewStudentListBanner();
        List<Student> studentList = dao.getStudentList();
        view.displayStudentList(studentList);
    }

    private void addStudent() throws StudentQuizGradesDaoException {
        view.displayAddStudentBanner();
        Student newStudent = view.getStudent();
        Student newlyAddedStudent = dao.addStudent(newStudent);
        view.displayAddStudentSuccessBanner();
        view.displayStudent(newlyAddedStudent);
    }

    private void removeStudent() throws StudentQuizGradesDaoException {
        view.displayRemoveStudentBanner();
        String name = view.getStudentName();
        Student removedStudent = dao.removeStudent(name);
        view.displayRemoveStudentResultBanner(removedStudent);
    }

    private void viewStudentQuizScoresList() {
        view.displayViewStudentQuizScoresListBanner();
        String name = view.getStudentName();
        List<Integer> quizScores = dao.getQuizScores(name);
        view.displayQuizScoresList(quizScores);
    }

    private void viewStudentAverageQuizScore() {
        view.displayViewStudentAverageQuizScoreBanner();
        String name = view.getStudentName();
        Float averageQuizScore = dao.getAverageQuizScore(name);
        view.displayAverageQuizScore(averageQuizScore);
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

}


