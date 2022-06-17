package L9.mycollection;
/* Created by limxuanhui on 16/6/22 */

import java.util.List;
import java.util.Vector;

// LinkedList --> good for insertion and deletion

public class TestCollection2 {
    public static void main(String[] args) {
//        doubly linked
//        List<String> mylist = new LinkedList<>();


        List<String> mylist = new Vector<>();
        mylist.add("Desmond");
        mylist.add("Adam");
        mylist.add("Beatrix");
        mylist.add("Chris");

        System.out.println(mylist);
    }
}
