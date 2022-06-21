package L12;
/* Created by limxuanhui on 21/6/22 */

public class L12Q2 {
    /*
      2) Who scored minimum marks in math.
    */
    public static void main(String[] args) {
        Student student1 = new Student("Adam", 90, 80, 90, 100);
        Student student2 = new Student("Bob", 70, 80, 90, 40);
        Student student3 = new Student("Chris", 80, 99, 90, 100);
        Student student4 = new Student("David", 70, 80, 70, 70);
        Student student5 = new Student("Ethan", 90, 20, 90, 100);

        School school = new School("good school");
        school.enrol(student1);
        school.enrol(student2);
        school.enrol(student3);
        school.enrol(student4);
        school.enrol(student5);
        System.out.println("Year average: " + school.getYearAverage());
        System.out.println("Year top scorer: " + school.getTopScorer());
        System.out.println("Year lowest scorer: " + school.getLowestScorer());
        System.out.println("Year Math lowest scorer: " + school.getMathLowestScorer());
    }
}
