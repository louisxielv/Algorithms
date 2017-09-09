package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 5/25/17.
 */

/*Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

        Assumptions

        The string is not null

        The characters used in the original string are guaranteed to be ‘a’ - ‘z’

        There are no adjacent repeated characters with length > 9

        Examples

        “a1c0b2c4” → “abbcccc”*/

public class DecompressStringII {
    public String decompress(String input) {
        if (input.length() == 0) {
            return input;
        }

        String shorter = decodeShorter(input.toCharArray());
        String longer = decodeLonger(shorter.toCharArray());
        return longer;
    }

    private String decodeLonger(char[] chars) {
        int newLength = getLength(chars);
        char[] array = new char[newLength];
        int end = array.length - 1;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isDigit(chars[i])) {
                int count = Character.getNumericValue(chars[i]);
                char temp = chars[i - 1];
                while (count > 1) {
                    array[end--] = temp;
                    count--;
                }
            }
            else {
                array[end--] = chars[i];
            }
        }

        return new String(array);
    }

    private int getLength(char[] chars) {
        int result = chars.length;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                result += (Character.getNumericValue(chars[i]) - 2);
            }
        }

        return result;
    }

    private String decodeShorter(char[] chars) {
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if(Character.isAlphabetic(chars[i])) {
                chars[end++] = chars[i];
            }
            else{
                int count = Character.getNumericValue(chars[i]);
                if (count == 1) {
                    continue;
                }
                else if (count == 0) {
                    end--;
                }
                else {
                    chars[end++] = chars[i];
                }
            }
        }

        return new String(chars, 0, end);
    }

    public static void main(String[] args) {
        DecompressStringII dc = new DecompressStringII();
        int length = dc.getLength(new char[]{'a', '5', 'c', '3'});
        String s1 = dc.decodeLonger(new char[]{'a', '5', 'c', '3'});
        String s2 = dc.decodeShorter(new char[]{'a', '0', 'b', '1'});

        System.out.println(length);

        System.out.println(s1);
        System.out.println(s2);


    }
}
