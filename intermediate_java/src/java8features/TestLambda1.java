package java8features;
/* Created by limxuanhui on 21/6/22 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLambda1 {
    public static void main(String[] args) {
        List<Integer> mynum = Arrays.asList(2,3,45,56,23,67,88);
        Integer[] x = new Integer[]{};
        System.out.println(mynum);
        
        // map, filter, reduce
//        mynum.stream().map(i -> i*i).forEach(j -> System.out.println(j));
        Stream<Integer> output = mynum.stream().map(i -> i*i);
        System.out.println(output);
        System.out.println(output.collect(Collectors.toList()));

        // reduce --> apply some functionality and reduce to one output
        System.out.println(mynum.stream().reduce((i,j) -> i+j));
        System.out.println(mynum.stream().reduce((i,j) -> i+j).get());
        System.out.println(mynum.stream().reduce((i,j) -> i+j).isPresent());
    }
}
