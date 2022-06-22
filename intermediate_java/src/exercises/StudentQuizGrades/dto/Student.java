package exercises.StudentQuizGrades.dto;
/* Created by limxuanhui on 21/6/22 */

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> quizScores;

    public Student(String name) {
        this.name = name;
        this.quizScores = new ArrayList<>();
    }

    public Student(String name, List<Integer> quizScores) {
        this(name);
        this.quizScores = quizScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getQuizScores() {
        return quizScores;
    }
}
