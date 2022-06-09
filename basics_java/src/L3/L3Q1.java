package L3;
/* Created by limxuanhui on 8/6/22 */

public class L3Q1 {
    /*
        1) WAP to calculate how many times a particular word
        is getting repeated in a paragraph of your choice.
    */

    public static void main(String[] args) {
        String paragraph = "What is the meaning of this? What is the meaning of living? What is the meaning of programming?";
        String targetWord = "What";
        String[] splittedParagraph = paragraph.split(" ");

        int count = 0;
        for (String s : splittedParagraph) {
            if (s.equals(targetWord)) {
                count++;
            }
        }
        System.out.println(targetWord + " appeared a total of " + count + " times.");
    }
}
