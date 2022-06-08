package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Arrays;

public class L2Q4 {
// 4) WAP to filter even numbers from [2,3,55,65,42,67]

    public static int[] filterEven(int[] arr) {
        int[] filteredArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                filteredArr[i] = arr[i];
            }
        }
        return filteredArr;
    }

    public static int[] cleanFilterEven(int[] arr) {
        int[] filteredArr = Arrays.stream(arr).filter(num -> num % 2 == 0).toArray();
        return filteredArr;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,55,65,42,67};
        int[] filteredArr = filterEven(arr);
        int[] cleanFilteredArr = cleanFilterEven(arr);
        System.out.println(Arrays.toString(filteredArr));
        System.out.println(Arrays.toString(cleanFilteredArr));
    }
}
