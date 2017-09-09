package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 5/1/17.
 */
public class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int index = 0, sign = 1, result = 0;
        // handle the white space
        str.trim();

        //handle the sign
        if (str.charAt(index) == '+') {
            index++;
        }else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while(index < str.length()) {
            int curr = str.charAt(index) - '0';
            if (curr > 9 || curr < 0) {
                break;
            }

            if (result >= (Integer.MAX_VALUE - curr) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + curr;
            index ++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        int result = atoi.myAtoi("2147483648");
        System.out.println(result);
    }
}
