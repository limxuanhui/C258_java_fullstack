package L11;
/* Created by limxuanhui on 20/6/22 */

import java.util.HashMap;
import java.util.Map;

public class TestCollection10 {
    public static void main(String[] args) {
        // hashmap --> unsorted, unordered
        Map<Integer, String> mymap = new HashMap<>();

        // hashtable doesn't allow anything null, neither key nor value
//        Map<Integer, String> mymap = new Hashtable<>();

        mymap.put(101, "Rajesh");
        mymap.put(102, "John");
        mymap.put(103, "Tom");
        mymap.put(null, "Harry");
        mymap.put(null, "Jack"); // overrides previous null key
        mymap.put(null, null); // overrides previous null key

        System.out.println(mymap);
        System.out.println(mymap.get(2));

        for (String i : mymap.values()) {
            System.out.println(i);
        }

    }
}
