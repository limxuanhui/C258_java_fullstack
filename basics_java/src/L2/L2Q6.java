package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Arrays;

public class L2Q6 {
    /*
    6) WAP to perform sorting of below array [2,34,56,12,34,1,5] using function
       both in ascending and descending order one by one.
       Input one array and output two array.*/

    public static int[] sortArr(int[] arr, boolean sortAscend) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        if (sortAscend) {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = 0; i < arr.length - 1; i++) {
                    if (sortedArr[i] > sortedArr[i+1]) {
                        int temp = sortedArr[i];
                        sortedArr[i] = sortedArr[i+1];
                        sortedArr[i+1] = temp;
                        swapped = true;
                    }
                }
            }
        } else {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = 0; i < arr.length - 1; i++) {
                    if (sortedArr[i] < sortedArr[i+1]) {
                        int temp = sortedArr[i];
                        sortedArr[i] = sortedArr[i+1];
                        sortedArr[i+1] = temp;
                        swapped = true;
                    }
                }
            }
        }
        return sortedArr;
    }

    public static int[][] sortUpDown(int[] arr) {
        int[][] sortedArrs = new int[2][];
        int[] sortedAscend = sortArr(arr, true);
        int[] sortedDescend = sortArr(arr, false);
        sortedArrs[0] = sortedAscend;
        sortedArrs[1] = sortedDescend;
        return sortedArrs;
    }

    public static void main(String[] args) {
        int[] arr = {2,34,56,12,34,1,5};
        int[][] sortedArrs = sortUpDown(arr);
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Ascending order: " + Arrays.toString(sortedArrs[0]));
        System.out.println("Descending order: " + Arrays.toString(sortedArrs[1]));
    }
}
