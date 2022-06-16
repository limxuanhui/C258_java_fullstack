package L7;
/* Created by limxuanhui on 14/6/22 */

/*
What methods would a class that implements the java.lang.CharSequence interface have to implement?
Answer: length(), charAt(), subsequence()

What is wrong with the following interface?
    public interface SomethingIsWrong {
        void aMethod(int aValue){
            System.out.println("Hi Mom");
        }
    }
Answer: Should not have concrete method

Fix the interface in question 2.
    public interface SomethingIsWrong {
        void aMethod(int aValue);
    }

Is the following interface valid?
    public interface Marker {
    }
Answer: Yes

*/

/*
   Write a class that implements the CharSequence interface found in the java.lang package.
   Your implementation should return the string backwards.
   Select one of the sentences from this book to use as the data. Write a small main method to test your class;
   make sure to call all four methods.
*/
class CharSequenceImpl implements CharSequence {
    private char[] charSeq;
    private int length;

    public CharSequenceImpl(char[] charSeq, int length) {
        this.charSeq = charSeq;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        char c = '\u0000';
        try {
            c = charSeq[index];
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Index out of bounds");
        }
        return c;
    }

    @Override
    public String subSequence(int start, int end) {
        char[] newSubChars = new char[end-start];
        for (int i = 0; i < end-start; i++) {
            newSubChars[i] = charSeq[i+start];
        }
        return new String(newSubChars);
    }

    public String reverse() {
        char[] reversedChars = new char[length];
        for (int i = 0; i < length; i++) {
            reversedChars[i] = charSeq[length-i-1];
        }
        return new String(reversedChars);
    }
}

public class L7Q4 {
    public static void main(String[] args) {
        char[] charSeq = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        CharSequenceImpl charSeq1 = new CharSequenceImpl(charSeq, 26);
        System.out.println(charSeq1.charAt(17));
        System.out.println(charSeq1.length());
        System.out.println(charSeq1.subSequence(1,17));
        System.out.println(charSeq1.reverse());
    }
}
