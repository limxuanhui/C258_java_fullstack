package exercises.StudentQuizGrades.ui;
/* Created by limxuanhui on 21/6/22 */

import exercises.StudentQuizGrades.dto.Student;
import io.UserIO;

import java.util.ArrayList;
import java.util.List;

public class StudentQuizGradesView {
    private UserIO io;

    public StudentQuizGradesView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetMenuSelection() {
        displayMenu();
        return io.readInt("Choose an option from above: ", 1, 9);
    }

    public void displayMenu() {
        io.print("=== Student Quiz Grades ===");
        io.print("1. View the list of students");
        io.print("2. Add a student");
        io.print("3. Remove a student");
        io.print("4. View the list of quiz scores of a given student");
        io.print("5. View the average quiz score of a given student");
        io.print("6. Average quiz score of all student");
        io.print("7. View highest quiz scorer(s)");
        io.print("8. View lowest quiz scorer(s)");
        io.print("9. Exit");
    }

    public void displayViewStudentListBanner() {
        io.print("=== Student List ===");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student student : studentList) {
            String studentString = "Name: " + student.getName()
                                   + " | Quiz scores: " + student.getQuizScores();
            io.print(studentString);
        }
        io.readString("Please hit enter to continue _");
    }

    public void displayAddStudentBanner() {
        io.print("=== Add Student ===");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print("Name: " + student.getName());
            io.print("Quiz scores: " + student.getQuizScores());
        } else {
            io.print("No such student");
        }
        io.readString("Please hit enter to continue _");
    }

    public void displayAddStudentSuccessBanner() {
        io.print("Student successfully added");
        io.readString("Please hit enter to continue _");
    }

    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveStudentResultBanner(Student student) {
        if (student != null) {
            io.print("Student successfully removed");
        } else {
            io.print("No such student");
        }
        io.readString("Please hit enter to continue _");
    }

    public void displayViewStudentQuizScoresListBanner() {
        io.print("=== Student Quiz Scores List ===");
    }

    public void displayQuizScoresList(List<Integer> quizScores) {
        if (quizScores != null) {
            io.print(quizScores.toString());
        } else {
            io.print("No quiz score belonging to student");
        }
        io.readString("Please hit enter to continue _");
    }

    public void displayAverageQuizScore(Float averageQuizScore) {
        if (averageQuizScore != null) {
            io.print("Average: " + averageQuizScore);
        } else {
            io.print("No average quiz score belonging to student");
        }
        io.readString("Please hit enter to continue _");
    }

    public void displayViewStudentAverageQuizScoreBanner() {
        io.print("=== Student Quiz Average Score ===");
    }

    public void displayViewClassAverageQuizScoreBanner() {
        io.print("=== Class Average Quiz Score ");
    }

    public void displayClassAverageQuizScore(Float average) {
        if (average != null) {
            io.print("Class average: " + average);
        } else {
            io.print("No average");
        }
        io.readString("Please hit enter to continue _");
    }

    public void displayViewHighestScorersBanner() {
        io.print("=== Highest Scorer(s) ===");
    }

    public void displayViewLowestScorersBanner() {
        io.print("=== Lowest Scorer(s) ===");
    }

    public void displayUnknownCommand() {
        io.print("Unknown command");
    }

    public void displayExitMessage() {
        io.print("Bye!");
    }

    public void displayErrorMessage(String message) {
        io.print("=== Error ===");
        io.print(message);
    }

    public String getStudentName() {
        return io.readString("Enter your name");
    }

    public List<Integer> getQuizScores() {
        List<Integer> quizData = new ArrayList<>();
        int numOfQuiz = io.readInt("Enter the number of quizzes to add: ");
        for (int i = 1; i <= numOfQuiz; i++) {
            quizData.add(io.readInt("Quiz " + i + " score: "));
        }
        return quizData;
    }

    public Student getStudent() {
        String name = "";
        while (name.isEmpty()) {
            name = getStudentName();
        }
        List<Integer> quizScores = getQuizScores();
        return new Student(name, quizScores);
    }


}
