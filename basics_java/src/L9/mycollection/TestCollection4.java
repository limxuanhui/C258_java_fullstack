package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.LinkedHashSet;
import java.util.Set;


// LinkedHashSet --> ordered
public class TestCollection4 {
    public static void main(String[] args) {
        Set<String> myset = new LinkedHashSet<>();

        myset.add("Rajesh");
        myset.add("John");
        myset.add("Tom");
        myset.add("Tom");
        System.out.println(myset);
    }
}
