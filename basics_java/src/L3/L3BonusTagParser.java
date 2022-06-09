package L3;
/* Created by limxuanhui on 8/6/22 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class L3BonusTagParser {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> parsedContents = new ArrayList<String>();

    public static void parseLine(String s) {
        String currentTag;
        boolean currentTagClosed;
        int startTagLeftIndex;
        int startTagRightIndex;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                startTagLeftIndex = i;
                startTagRightIndex = s.indexOf('>', i);
//                String tagName = getTagName(s, )
//                s.indexOf(tagName, startTagRightIndex+1);
            }
        }
    }

    public static String getContent(String s, int start, int end) {
        return "";
    }

    public static String getTagName(String tag) {
        String tagName = tag.substring(1, tag.length()-1);
        return tagName;
    }

    public static String getNextTag(String s, int nextIndex) {
        int leftBracketIndex = s.indexOf('<', nextIndex);
        int rightBracketIndex = s.indexOf('>', leftBracketIndex);
        String nextTag = s.substring(leftBracketIndex, rightBracketIndex+1);
        return nextTag;
    }

    public static boolean isTag(String tag) {
        if (tag.startsWith("<") && tag.endsWith(">")) {
            return true;
        }
        return false;
    }

    public static boolean isClosingTag(String tag) {
        if (isTag(tag) && getTagName(tag).startsWith("/")) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> extractContent(String s, Stack<String> openTagsStack) {
        // if string s is empty, return empty arraylist

        // get next tag

        // if is opening tag, push to stack, recurse with substring from end of opening tag

        // if is closing tag, if yes, check if top of opentagstack contains valid open tag





        String originalString = s;
        String currentString = s;
        String currOpenTag = getNextTag(currentString, 0);
        openTagsStack.push(currOpenTag);

        // recursive call on substring
        ArrayList<String> contents = extractContent("", openTagsStack);
        parsedContents.addAll(contents);

        return null;
    }


    public static void main(String[] args) {
        // Use stack to save open tag
//        System.out.println("Please enter your string:");
//        String s = scanner.nextLine();

        // - given string, find every open tag and push to stack
        //   until we find a close tag
        // - check if close tag is valid pair with open tag on top of stack
        //   by checking tagname
        // - if valid, output content
        // - if not valid, pop top of stack and find next closing tag
        // - repeat until stack is empty

        // repeat for remaining parts of string
        String s = "<h1>Nayeem loves counseling</h1>";
        Stack<String> openTagStack = new Stack<>();
//        String[] contents = extractContent(s, openTagStack);

    }
}
