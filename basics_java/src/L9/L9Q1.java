package L9;
/* Created by limxuanhui on 16/6/22 */

import java.util.ArrayList;
import java.util.Collections;

public class L9Q1 {

    public static void printRandomly(ArrayList<Integer> arr) {
        Collections.shuffle(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        printRandomly(arr);
    }
}
