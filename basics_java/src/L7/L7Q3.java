package L7;
/* Created by limxuanhui on 14/6/22 */

import java.util.HashMap;

public class L7Q3 {
    /*
      3) WAP to measure the impact of your hashcode algorithm by
         checking system time taken for searching.
         use System.nanoTime() to calculate time before start and after end of algo
     */

    public static void main(String[] args) {
        /*
          Comment out equals and hashCode methods in L7Q2 Student class and run this main method again to see time difference.
        */
        HashMap<Student, Integer> students = new HashMap<>();

        for (int i = 0; i < 999999; i++) {
            System.out.println("-----In Loop-----");
            students.put(new Student(i, "John"+i), i);
        }
        System.out.println("===== Out of loop =====");

        long startTimeStudent = System.nanoTime();
        students.get(new Student(999999, "John999999"));
        long endTimeStudent = System.nanoTime();
        System.out.println("Time taken for finding student: " + (endTimeStudent-startTimeStudent) + " nanoseconds");
    }
}
