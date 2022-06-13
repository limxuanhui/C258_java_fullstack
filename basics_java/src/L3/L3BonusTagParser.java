package L3;
/* Created by limxuanhui on 8/6/22 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class L3BonusTagParser {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> parsedContents = new ArrayList<>();

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
        String tagName;
        if (isOpeningTag(tag)) {
            tagName = tag.substring(1, tag.length()-1);
        } else if (isClosingTag(tag)) {
            tagName = tag.substring(2, tag.length()-1);
        } else {
            return null;
        }
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

    public static boolean isOpeningTag(String tag) {
        if (isTag(tag) && !isClosingTag(tag)) {
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

    public static boolean checkValidOpenCloseTags(String openTag, String closeTag) {
        return getTagName(openTag) == getTagName(closeTag);
    }

    public static String extractContent(String s, String openTag, String closeTag) {
        int openIndex = s.indexOf(openTag);
        int closeIndex = s.indexOf(closeTag);
        String content = s.substring(openIndex + openTag.length(), closeIndex);
        return content;
    }

    public static String recursiveParse(String s, Stack<String> openTagsStack) {

        // if string s is empty, return null
        if (s.isEmpty()) {
            return null;
        }

        // get next tag
        String nextTag = getNextTag(s, 0);
        if (isOpeningTag(nextTag)) {
            // push to stack
            openTagsStack.push(nextTag);

            // recurse with substring from end of opening tag
            String subString = s.substring(nextTag.length());
            String extractedContent = recursiveParse(subString, openTagsStack);
            parsedContents.add(extractedContent);
        }
        else if (isClosingTag(nextTag)) {
            if (checkValidOpenCloseTags(openTagsStack.peek(), nextTag)) {
                // extract content
                String content = extractContent(s, openTagsStack.peek(), nextTag);
                return content;
            } else {
                // invalid pair
            }
        }
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
