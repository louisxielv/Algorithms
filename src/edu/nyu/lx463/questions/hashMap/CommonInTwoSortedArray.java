package edu.nyu.lx463.questions.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LyuXie on 4/25/17.
 */
public class CommonInTwoSortedArray {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here.
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> countA = new HashMap<>();
        for (Integer a : A) {
            Integer count = countA.get(a);
            if (count == null) {
                countA.put(a, 1);
            }
            else {
                countA.put(a, count + 1);
            }
        }

        Map<Integer, Integer> countB = new HashMap<>();
        for (Integer b : B) {
            Integer count = countB.get(b);
            if (count == null) {
                countB.put(b, 1);
            }
            else {
                countB.put(b, count + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: countA.entrySet()) {
            Integer key = entry.getKey();
            Integer countInB = countB.get(key);
            if (countInB == null) {
                continue;
            }
            else {
                for (int i = 0; i < Math.min(countInB, entry.getValue()); i++) {
                    result.add(key);
                }
            }
        }

        return result;
    }
}
