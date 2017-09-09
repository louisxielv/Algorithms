package edu.nyu.lx463.questions.Graph;

/**
 * Created by LyuXie on 4/15/17.
 */
public class Main {
    public static void main(String[] args) {
//        CheckIfBinaryTreeIsCompleted c = new CheckIfBinaryTreeIsCompleted();
        TreeNode one = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(3);
        TreeNode three1 = new TreeNode(4);
        TreeNode three2 = new TreeNode(5);
        TreeNode three3 = new TreeNode(6);
        TreeNode three4 = new TreeNode(7);

        one.left = two1;
        one.right = two2;
        two1.left = three1;
        two1.right = three2;
        two2.left = null;
        two2.right = three4;

        FlattenTree flattenTree = new FlattenTree();
        flattenTree.flatten(one);
//
//        boolean result = c.isCompleted(one);
//        System.out.print(result);

//        int[][] matrix= new int[][]{
//                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
//                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
//                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
//                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
//                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
//                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
//                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
//                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
//        };
//
//        ZeroOneMatrix zom = new ZeroOneMatrix();
//        List<List<Integer>> result = zom.updateMatrix(matrix);
//
//        for(List<Integer> list : result) {
//            for (int i: list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//    }
}}
