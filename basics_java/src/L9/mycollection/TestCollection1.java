package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


// ArrayList --> powerful array, with no predefined size

public class TestCollection1 {

    public static void main(String[] args) {
//        List mylist = new ArrayList<String>();
        List<String> mylist = new ArrayList<>();
        mylist.add("Desmond");
        mylist.add("Adam");
        mylist.add("Beatrix");
        mylist.add("Chris");
//        mylist.add(123);
//        mylist.add(false);

        // toString() of ArrayList modified
        System.out.println(mylist);
        Collections.sort(mylist);
        System.out.println(mylist);

        for (String name : mylist) {
            System.out.println(name);
        }

        Iterator<String> itr = mylist.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        mylist.remove("Christ");
        System.out.println(mylist);
        mylist.remove("Chris");
        System.out.println(mylist);
    }
}
