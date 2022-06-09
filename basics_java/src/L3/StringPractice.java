package L3;
/* Created by limxuanhui on 8/6/22 */

import java.util.Locale;

public class StringPractice {

    public static void main(String[] args) {
        char[] chars = {'R','a','j','e','s','h'};
        String name = new String(chars);
        System.out.println(name);
        System.out.println(name.equals("rajesh"));
        System.out.println(name.substring(3));
        System.out.println(name.charAt(3));
        System.out.println(name.toLowerCase(Locale.ROOT));
        System.out.println(name.toUpperCase(Locale.ROOT));
        System.out.println(name.substring(2,5));
        System.out.println(name.length());
        System.out.println(name.concat("Sharma"));
        System.out.println(name.contains("h"));
        System.out.println(name.endsWith("t"));
        System.out.println(name.indexOf("t"));
        System.out.println(name.lastIndexOf("t"));
        System.out.println(name.replace("e", "i"));
        StringDog sd = new StringDog();
        System.out.println(sd);
    }
}
