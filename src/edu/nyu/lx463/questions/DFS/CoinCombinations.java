package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 4/17/17.
 */
public class CoinCombinations {
        public List<List<Integer>> combinations(int target, int[] coins) {
            // Write your solution here.
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> list = new ArrayList<>();
            dfs(target, coins, 0, result, list);
            return result;
        }

        private void dfs(int target, int[] coins, int index, List<List<Integer>> result, List<Integer> list) {
            if (index == coins.length) {
                if (target == 0) {
                    result.add(new ArrayList<Integer>(list));
                }
                return;
            }

            int coin = coins[index];
            for (int i = 0; i * coin <= target; i++) {
                list.add(i);
                dfs(target - i * coin, coins, index + 1, result, list);
                list.remove(list.size() - 1);
            }
        }


}
