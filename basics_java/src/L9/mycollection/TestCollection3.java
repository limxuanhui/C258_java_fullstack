package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.HashSet;
import java.util.Set;

// Set --> general purpose, unordered, unsorted, takes only unique items
public class TestCollection3 {

    public static void main(String[] args) {
        Set<String> myset = new HashSet<>();

        myset.add("Rajesh");
        myset.add("John");
        myset.add("Tom");
        myset.add("Tom");
        System.out.println(myset);
    }
}
