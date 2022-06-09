package L3;
/* Created by limxuanhui on 8/6/22 */

import java.util.Locale;

public class L3Q2 {
    /*
        2) WAP to find the number of vowels in a string.
    */

    public static void vowelCount(String s) {
        String s2 = s.toLowerCase(Locale.ROOT);
        System.out.println(s2);
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s2.charAt(i) == 'a') aCount++;
            else if (s2.charAt(i) == 'e') eCount++;
            else if (s2.charAt(i) == 'i') iCount++;
            else if (s2.charAt(i) == 'o') oCount++;
            else if (s2.charAt(i) == 'u') uCount++;
        }

        System.out.println("=== Vowel count ===");
        System.out.println("a: " + aCount);
        System.out.println("e: " + eCount);
        System.out.println("i: " + iCount);
        System.out.println("o: " + oCount);
        System.out.println("u: " + uCount);
    }

    public static void main(String[] args) {
        String s = "the Quick Brown fOx jUmpS ovER thE lAzy dOg";
        vowelCount(s);
    }
}
