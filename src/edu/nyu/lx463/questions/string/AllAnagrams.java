package edu.nyu.lx463.questions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LyuXie on 4/29/17.
 */
public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        // Write your solution here.
        List<Integer> result = new ArrayList<>();
        if (l.length() == 0 || s.length() > l.length()) {
            return result;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (count.get(curr) == null) {
                count.put(curr, 1);
            }
            else {
                count.put(curr, count.get(curr) + 1);
            }
        }

        int typeOfCharacters = count.size();

        for (int i = 0; i < l.length(); i++) {
            char curr = l.charAt(i);
            if (count.get(curr) != null) {
                count.put(curr, count.get(curr) - 1);
                if (count.get(curr) == 0) {
                    typeOfCharacters--;
                }
            }

            if (i >= s.length()) {
                char temp = l.charAt(i - s.length());
                Integer value = count.get(temp);
                if (value != null) {
                    if (value == 0) {
                        typeOfCharacters++;
                    }
                    count.put(temp, count.get(temp) + 1);
                }
            }

            if (typeOfCharacters == 0) {
                result.add(i - s.length() + 1);
            }

        }

        return result;
    }
    public static void main(String[] args) {
        AllAnagrams aa = new AllAnagrams();
        List<Integer> result = aa.allAnagrams("aa", "baaa");
        for (Integer i: result) {
            System.out.println(i.intValue());
        }
    }
}
