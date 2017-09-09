package edu.nyu.lx463.questions.tree;

import java.util.TreeMap;

/**
 * Created by LyuXie on 6/6/17.
 */
public class ClosestBST {
    public int closest(TreeNode root, int target) {
        // Write your solution here.
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        TreeNode result = null;
        helper(root, target, min, result);
        return result.key;

    }

    private void helper(TreeNode root, int target, int[] min, TreeNode result) {
        if (root == null) {
            return;
        }

        if (Math.abs(root.key - target) < min[0]) {
            min[0] = Math.abs(root.key - target);
            result = root;
        }

        if (root.key > target) {
            helper(root.left, target, min, result);
        }
        else if (root.key < target) {
            helper(root.right, target, min, result);
        }
        else {
            result = root;
            return;
        }

    }

    public static void main(String[] args) {
        ClosestBST clo = new ClosestBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        clo.closest(root, 3);
    }
}
