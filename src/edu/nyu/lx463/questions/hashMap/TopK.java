package edu.nyu.lx463.questions.hashMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by LyuXie on 4/25/17.
 */
public class TopK {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here.
        if (k >= combo.length || combo.length == 0) {
            return combo;
        }

        Map<String, Integer> hashMap = getFreqMap(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }


        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : combo) {
            Integer freq = hashMap.get(s);
            if (freq == null) {
                hashMap.put(s, 1);
            } else {
                hashMap.put(s, freq + 1);
            }
        }

        return hashMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> pq) {

        String[] result = new String[pq.size()];

        for(int i = pq.size() - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;

    }
}
