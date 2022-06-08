package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Arrays;

public class L2Pattern1 {
    public static void printTriangle(int i) {
        while (i-- > 0) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printTriangle2(int i) {
        for (int k = 0; k < i; k++) {
            for (int j = 0; j <= k; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printChristmasTree(int i) {
        // printing leaves and branches
        for (int level = 0; level < i; level++) {
            for (int left = 0; left < (2*i-1-2*level+1)/2; left++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*level+1); j++) {
                System.out.print("*");
            }
            for (int right = 0; right < (2*i-1-2*level+1)/2; right++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // printing trunk
        for (int trunk = 0; trunk < 2; trunk++) {
            for (int left = 0; left < (2*i-1)/2; left++) {
                System.out.print(" ");
            }
            System.out.print("***");
            for (int right = 0; right < (2*i-1)/2; right++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        printTriangle(7);
//        printTriangle2(6);
        printChristmasTree(5);
        int count = 5;char rep = 'f';

//        System.out.println(String.format("%"+count+"s", "").replace(' ', rep));

        int[] arr = new int[10];
        Arrays.setAll(arr, p -> 99);
        System.out.println(Arrays.toString(arr));

        Arrays.fill(arr, 101);
        System.out.println(Arrays.toString(arr));
    }
}
