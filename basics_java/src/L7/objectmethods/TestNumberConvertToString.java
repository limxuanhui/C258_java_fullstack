package L7.objectmethods;
/* Created by limxuanhui on 14/6/22 */

import java.util.Scanner;

class NumberStringify {
    private int num;

    public NumberStringify(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    public static int toNum(String numString) {
        return Integer.parseInt(numString);
    }
}

public class TestNumberConvertToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a number:");
        int num = scanner.nextInt();

        NumberStringify ns = new NumberStringify(num);
        System.out.println(ns);
        System.out.println(ns.toString() instanceof String);
        NumberStringify.toNum("201");
    }
}
