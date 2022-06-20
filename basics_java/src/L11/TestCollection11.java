package L11;
/* Created by limxuanhui on 20/6/22 */

import java.util.Map;
import java.util.TreeMap;

public class TestCollection11 {
    public static void main(String[] args) {
//        Map<Integer, String> mymap = new LinkedHashMap<>();

        // treemap doesnt accept null keys, but null values are accepted
        Map<Integer, String> mymap = new TreeMap<>();

        // hashtable doesn't allow anything null, neither key nor value
//        Map<Integer, String> mymap = new Hashtable<>();

        mymap.put(101, "Rajesh");
        mymap.put(102, "John");
        mymap.put(103, "Tom");
//        mymap.put(null, "Harry");
        mymap.put(104, null);
//        mymap.put(null, "Jack"); // overrides previous null key
//        mymap.put(null, null); // overrides previous null key

        System.out.println(mymap);

        for (String i : mymap.values()) {
            System.out.println(i);
        }
    }
}
