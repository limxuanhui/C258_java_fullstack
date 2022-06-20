package L11;
/* Created by limxuanhui on 20/6/22 */

import java.util.ArrayList;
import java.util.stream.Collectors;

public class L11Q2 {
    /*
      2) Create another two outputs one with even items and another with odd items.
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
        ArrayList<Integer> evenList = myList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> oddList = myList.stream()
                .filter(i -> i % 2 == 1)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(myList);
        System.out.println(evenList);
        System.out.println(oddList);
    }
}
