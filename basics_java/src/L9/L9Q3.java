package L9;
/* Created by limxuanhui on 16/6/22 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class L9Q3 {
    public static List<String> trimEach(List<String> list) {
        return list.stream().map(String::trim).collect(Collectors.toList());
    }

    public static void trimAll(List<String> list) {
        list.replaceAll(String::trim);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(" adbce   ");
        list.add(" aeormd   ");
        list.add(" salelm   ");
        list.add(" x   ");
        list.add(" dgg   ");
        System.out.println(list);

        // returns new List
//        list = trimEach(list);

        // returns original list as trim is done in-place
        trimAll(list);
        System.out.println(list);
    }
}
