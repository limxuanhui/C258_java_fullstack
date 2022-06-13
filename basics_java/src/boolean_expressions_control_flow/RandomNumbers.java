package boolean_expressions_control_flow;
/* Created by limxuanhui on 9/6/22 */

import java.util.Random;

public class RandomNumbers {

    public static void main(String[] args) {
        Random rGen = new Random();
        // generates a number from 0 (inclusive) to 10 (exclusive). to get a random number from 1 to 10, add 1
        int rInt = rGen.nextInt(10) + 1;

        System.out.println(rInt-1);
        System.out.println(rInt);
    }
}
