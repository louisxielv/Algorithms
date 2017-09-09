package edu.nyu.lx463.questions.DFS;

import java.util.List;

/**
 * Created by LyuXie on 4/17/17.
 */
public class Main {
    public static void main(String[] args) {
//        AllSubsetsI alls = new AllSubsetsI();
//        List<String> result = alls.subSets(null);
//        for (String s: result) {
//            System.out.println(s);
//        }

//        CoinCombinations cc = new CoinCombinations();
//        List<List<Integer>> result = cc.combinations(99, new int[]{1, 5, 10, 25});
//        for (List<Integer> list : result) {
//            for (int i : list) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }

//        AllPermutationsI alls = new AllPermutationsI();
//        List<String> result = alls.permutations("abc");
//        for (String s: result) {
//            System.out.println(s);
//        }

//        DecodeString ds = new DecodeString();
//        String result = ds.decodeString("100[leetcode]");
//        System.out.print(result);

        LetterCombinationsPhoneNumber lc = new LetterCombinationsPhoneNumber();
        List<String> s = lc.letterCombinations("123");
        for (String ss : s) {
            System.out.println(ss);
        }

    }
}
