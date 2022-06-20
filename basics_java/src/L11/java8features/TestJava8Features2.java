package L11.java8features;
/* Created by limxuanhui on 20/6/22 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8Features2 {
    public static void main(String[] args) {
        List<Integer> mynum = Arrays.asList(2,3,45,56,23,67,88);
        System.out.println(mynum);
        List<Integer> myevennum = mynum.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(myevennum);
    }
}
