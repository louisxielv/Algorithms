package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 6/15/17.
 */
public class FactorCombination {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs(list, result, 0, factors, n);
        return result;
    }

    private void dfs(List<Integer> list, List<List<Integer>> result, int index, List<Integer> factors, int target) {

        if (target == 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (index >= factors.size()) {
            return;
        }

        int factor = factors.get(index);
        int now = 1;
        int numberOfFactors = 0;
        while (numberOfFactors * factor <= target) {
            if (target % now == 0) {
                for (int i = 0; i < numberOfFactors; i++) {
                    list.add(factor);
                }

                dfs(list, result, index + 1, factors, target / now);

                for (int i = 0; i < numberOfFactors; i++) {
                    list.remove(list.size() - 1);
                }

            }

            now = now * factor;
            numberOfFactors++;

        }
    }

    public static void main(String[] args) {
        FactorCombination fc = new FactorCombination();
        List<List<Integer>> list = fc.getFactors(12);
        for (List<Integer> li : list) {
            for (Integer i : li) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
}
