package edu.nyu.lx463.questions.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 4/27/17.
 */
public class StringReplacement {
    public String replace(String input, String s, String t) {
        if (input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        }

        return replaceLonger(array, s, t);
    }

    private String replaceShorter(char[] array, String s, String t) {
        int slow = 0, fast = 0;
        while (fast < array.length) {
            if (fast < array.length - s.length() && equalsSubstring(array, fast, s)) {
                copySubstring(array, slow, t);
                fast += s.length();
                slow += t.length();
            }else {
                array[slow++] = array[fast++];
            }
        }

        return new String(array, 0, slow);
    }

    private String replaceLonger(char[] array, String s, String t) {
        List<Integer> matches = getAllMatches(array, s);
        char[] longerArray = new char[array.length + (t.length() - s.length()) * matches.size()];
        int fast = array.length - 1;
        int slow = longerArray.length - 1;
        int pointer = matches.size() - 1;
        while(fast >= 0) {
            if (pointer >= 0 && fast == matches.get(pointer)) {
                copySubstring(longerArray, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                pointer--;
            }else {
                longerArray[slow--] = array[fast--];
            }
        }

        return new String(longerArray);
    }

    private boolean equalsSubstring(char[] array, int index, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (array[index + i] != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private void copySubstring(char[] array, int index, String t) {
        for (int i = 0; i < t.length(); i++) {
            array[index + i] = t.charAt(i);
        }
    }

    private List<Integer> getAllMatches(char[] array, String s) {
        List<Integer> matches = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (equalsSubstring(array, i, s)) {
                matches.add(i + s.length() - 1);
                i = i + s.length() - 1;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        StringReplacement sr = new StringReplacement();
        String result = sr.replace("student", "de", "yyy");
        System.out.println(result);
    }
}
