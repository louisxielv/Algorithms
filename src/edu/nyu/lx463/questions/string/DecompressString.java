package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 4/28/17.
 */
public class DecompressString {
    public String decompress(String input) {
        // Write your solution here.
        if (input.length() == 0) {
            return input;
        }
        String shorter = decompressShorter(input.toCharArray());
        return decompressLonger(shorter.toCharArray());
    }

    private String decompressShorter(char[] array) {
        int slow = 0, fast = 0;

        while (fast < array.length) {
            if (Character.isLetter(array[fast])) {
                array[slow++] = array[fast++];
            }
            else if (Character.isDigit(array[fast])) {
                if (Character.getNumericValue(array[fast]) == 0) {
                    fast++;
                    slow--;
                }
                else if (Character.getNumericValue(array[fast]) == 1){
                    fast++;
                }
                else {
                    array[slow++] = array[fast++];
                }
            }
        }

        return new String(array, 0, slow);
    }

    private String decompressLonger(char[] array) {
        int largerLength = getLength(array);
        char[] result = new char[largerLength];
        int fast = array.length - 1;
        int slow = result.length - 1;

        while (fast >= 0) {
            if (Character.isDigit(array[fast])) {
                int count = Character.getNumericValue(array[fast--]);
                char digit = array[fast--];
                while (count > 0) {
                    result[slow--] = digit;
                    count--;
                }
            }
            else {
                result[slow--] = array[fast--];
            }
        }
        return new String(result);
    }

    private int getLength(char[] array) {
        int add = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i])) {
                add += (Character.getNumericValue(array[i]) - 2);
            }
        }

        return array.length + add;
    }

    public static void main(String[] args) {
        DecompressString ds = new DecompressString();
        String result = ds.decompress("a1c0b2c4");
        System.out.println(result);
    }
}
