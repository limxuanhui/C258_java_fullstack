package L11;
/* Created by limxuanhui on 20/6/22 */

import java.util.ArrayList;
import java.util.stream.Collectors;

public class L11Q1 {
    /*
      1) WAP to calculate the square of all the list items.
    */
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        ArrayList<Integer> newList = myList.stream()
                                           .map(i -> i*i)
                                           .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(myList);
        System.out.println(newList);
    }
}
