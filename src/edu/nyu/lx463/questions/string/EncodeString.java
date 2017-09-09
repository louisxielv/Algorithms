package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 7/14/17.
 */
public class EncodeString {
    // e.g. input = "aaaavavvbbbbaaaac"
    public String encode(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        int[] temp = replaceShorter(array);
        if (temp[1] > 0) {
            return replaceLonger(array, temp[0], temp[1]);
        }
        return new String(array, 0, temp[0]);
    }

    private int[] replaceShorter(char[] array) {
        int fast = 0, slow = 0;
        int numOfLonglyElement = 0;
        while (fast < array.length) {
            int count = count(array, fast);
            if (count >= 2) {
                array[slow++] = array[fast];
                fast += count;
                while (count > 10) {
                    array[slow++] = (char)('0' + count / 10);
                    count = count % 10;
                }
                array[slow++] = (char)('0' + count);


            }else {
                numOfLonglyElement++;
                array[slow++] = array[fast++];
            }
        }

        return new int[]{slow, numOfLonglyElement};
    }

    private String replaceLonger(char[] array, int length, int numOfLonglyElement) {
        int longLength = length + numOfLonglyElement;
        char[] longerArray = new char[longLength];
        int slow = longerArray.length - 1, fast = length - 1;
        while (fast >= 0) {
            if (getDigit(array[fast]) >= 2 && getDigit(array[fast]) <= 9) {
                longerArray[slow--] = array[fast--];
            }
			else{
                if (fast == array.length - 1 || getDigit(array[fast + 1]) > 9) {
                    longerArray[slow--] = '0' + 1;

                }
                longerArray[slow--] = array[fast--];
            }
        }

        return new String(longerArray);
    }

    private int getDigit(char c) {
        return c - '0';
    }

    private int count(char[] array, int fast) {
        int result = 1;
        while (fast < array.length - 1 && array[fast] == array[fast + 1]) {
            result++;
            fast++;
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeString ens = new EncodeString();
        String s = ens.encode("caaaaaaaaaaaaaaabbbbb");
        System.out.print(s);
    }
}
