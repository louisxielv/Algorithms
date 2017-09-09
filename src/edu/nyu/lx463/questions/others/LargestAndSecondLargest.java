package edu.nyu.lx463.questions.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 5/30/17.
 */
public class LargestAndSecondLargest {
    static class Element {
        int val;
        List<Integer> compared;
        Element(int val, List<Integer> compared) {
            this.val = val;
            this.compared = compared;
        }
    }
    public int[] largestAndSecond(int[] array) {
        Element[] elements = convert(array);
        int largerLength = array.length;

        while (largerLength > 1) {
            convertAndSwap(elements, largerLength);
            largerLength = (largerLength + 1) / 2;
        }

        return new int[]{elements[0].val, largest(elements[0].compared)};
    }

    private int largest(List<Integer> compared) {
        int max = compared.get(0);
        for (Integer i: compared) {
            max = Math.max(i, max);
        }
        return max;
    }

    private void convertAndSwap(Element[] elements, int largerLength) {
        int i = 0, j = largerLength - 1;
        while (i < j) {
            if (elements[i].val <= elements[j].val) {
                swap(elements, i, j);
            }
            elements[i].compared.add(elements[j].val);
            i++;
            j--;
        }
    }

    private void swap(Element[] elements, int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private Element[] convert(int[] array) {
        Element[] elements = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            Element temp = new Element(array[i], new ArrayList<Integer>());
            elements[i] = temp;
        }
        return elements;
    }

    public static void main(String[] args) {
        LargestAndSecondLargest ls = new LargestAndSecondLargest();
        int[]result = ls.largestAndSecond(new int[]{2, 1});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
