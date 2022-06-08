package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Arrays;
import java.util.Scanner;

public class L2Q5 {

    // 5) WAP to filter out even and odd numbers from an array of
    //    numbers from 1 to 50 using a function, input one array, output two array.

    public static Scanner scanner = new Scanner(System.in);

    public static int[][] filterEvenOdd(int[] arr) {
        int[][] filteredArrs = new int[2][arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                filteredArrs[0][i] = arr[i];
            } else {
                filteredArrs[1][i] = arr[i];
            }
        }
        return filteredArrs;
    }

    public static int[][] cleanFilterEvenOdd(int[] arr) {
        int[][] cleanFilteredArrs = new int[2][];
        cleanFilteredArrs[0] = Arrays.stream(arr).filter(num -> num % 2 == 0).toArray();
        cleanFilteredArrs[1] = Arrays.stream(arr).filter(num -> num % 2 == 1).toArray();
        return cleanFilteredArrs;
    }

    public static void main(String[] args) {
//        int[] arr = {2,3,55,65,42,67};
        System.out.println("Please input your number of integers:");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Please enter the integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int[][] cleanFilteredArrs = cleanFilterEvenOdd(arr);
        System.out.println("Your filtered integers are:");
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Even: " + Arrays.toString(cleanFilteredArrs[0]));
        System.out.println("Odd: " + Arrays.toString(cleanFilteredArrs[1]));
    }
}
