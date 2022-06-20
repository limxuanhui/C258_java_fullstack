package exercises;
/* Created by limxuanhui on 20/6/22 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StateCapitals {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Alabama", "Montgomery");
        map.put("Alaska", "Juneau");
        map.put("Arizona", "Phoenix");
        map.put("Arkansas", "Little Rock");

        Set<String> stateNames = map.keySet();
        Collection<String> capitalNames = map.values();

        System.out.println("STATES:");
        System.out.println("=======");
        for (String state : stateNames) {
            System.out.println(state);
        }

        System.out.println("CAPITALS:");
        System.out.println("=========");
        for (String capital : capitalNames) {
            System.out.println(capital);
        }

        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");
        for (String state : stateNames) {
            System.out.println(state + " - " + map.get(state));
        }
    }
}
