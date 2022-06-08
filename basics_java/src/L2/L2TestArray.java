package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Arrays;

public class L2TestArray {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        for (int x : numbers) {
            System.out.println(x);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + ". " + numbers[i]);
        }

        char[] chars = {'a', 'b', 'c'};
        String str = "abc";
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(chars));
        System.out.println(chars);
    }
}
