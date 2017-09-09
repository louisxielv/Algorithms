package edu.nyu.lx463.questions.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LyuXie on 5/31/17.
 */
public class SortInSpecificOrder {
    static class MyComparator implements Comparator<Integer> {
        Map<Integer, Integer> map;

        MyComparator(int[] array) {
            map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], i);
            }
        }

        @Override
        public int compare(Integer num1, Integer num2) {
            Integer index1 = map.get(num1);
            Integer index2 = map.get(num2);
            if (index1 != null && index2 != null) {
                return index1.compareTo(index2);
            }else if (index1 == null && index2 == null) {
                return num1.compareTo(num2);
            }

            return index1 == null ? 1 : -1;
        }

    }
    public int[] sortSpecial(int[] A1, int[] A2) {
        Integer[] refA1 = toIntegerArray(A1);
        Arrays.sort(refA1, new MyComparator(A2));
        int[] result = toIntArray(refA1);
        return result;
    }

    private int[] toIntArray(Integer[] refA1) {
        int[] result = new int[refA1.length];
        for (int i = 0; i < refA1.length; i++) {
            result[i] = refA1[i];
        }
        return result;
    }

    private Integer[] toIntegerArray(int[] a1) {
        Integer[] result = new Integer[a1.length];
        for (int i = 0; i < a1.length; i++) {
            result[i] = new Integer(a1[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        SortInSpecificOrder so = new SortInSpecificOrder();
        int[] result = so.sortSpecial(new int[]{2, 1, 2, 5, 7, 1, 9, 3}, new int[]{2,1,3});

    }
}
