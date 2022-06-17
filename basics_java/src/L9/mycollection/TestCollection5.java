package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.Set;
import java.util.TreeSet;


// TreeSet --> Ordered unique items
public class TestCollection5 {
    public static void main(String[] args) {
        Set<String> myset = new TreeSet<>();

        myset.add("Rajesh");
        myset.add("John");
        myset.add("Tom");
        myset.add("Tom");
        System.out.println(myset);
    }
}
