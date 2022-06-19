package L9.BankingBackendApp;
/* Created by limxuanhui on 16/6/22 */

import java.util.ArrayList;
import java.util.LinkedList;

public class App {
    private transient int x;
    private static String s = "";

    public static void main(String[] args) {
        System.out.println(s);
//        BankOfJoseph boj = new BankOfJoseph();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }

        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }

        long startTimeLL = System.nanoTime();
        System.out.println(linkedList.get(999999));
        long endTimeLL = System.nanoTime();
        System.out.println("Time taken for LinkedList: " + (endTimeLL - startTimeLL) + " nanoseconds");

        long startTimeAL = System.nanoTime();
        System.out.println(arrayList.get(999999));
        long endTimeAL = System.nanoTime();
        System.out.println("Time taken for ArrayList: " + (endTimeAL - startTimeAL) + " nanoseconds");
    }
}
