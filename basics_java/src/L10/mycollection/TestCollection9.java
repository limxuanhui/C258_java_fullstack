package L10.mycollection;
/* Created by limxuanhui on 17/6/22 */

// Map --> key value pair

import java.util.Hashtable;
import java.util.Map;

public class TestCollection9 {

    public static void main(String[] args) {
        // hashtable is general purpose map
        Map<Integer, String> mymap = new Hashtable<>();

        mymap.put(101, "rajesh");
        mymap.put(102, "john");
        mymap.put(103, "tom");
//        mymap.put(103, "tom"); // no duplicate keys allowed
        System.out.println(mymap);

        for (Integer i : mymap.keySet()) {
            System.out.println(mymap.get(i));
        }

    }
}
