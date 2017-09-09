package edu.nyu.lx463.questions.string;

import java.text.DecimalFormat;

/**
 * Created by LyuXie on 5/13/17.
 */
public class DedupII {

    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        int slow = 0, fast = 1;

        while (fast < input.length()) {
            if (slow >= 0 && inputArray[fast] == inputArray[slow] ){
                while (fast < input.length() && inputArray[fast] == inputArray[slow]) {
                    fast++;
                }
                slow--;
                if (fast >= input.length()) {
                    break;
                }
            }

            else{
                inputArray[++slow] = inputArray[fast++];
            }
        }

        return new String(inputArray, 0, slow + 1);
    }

    public static void main(String[] args) {
        DedupII dd = new DedupII();
        String result = dd.deDup("bsasdwwww");
        System.out.print(result);
    }
}
