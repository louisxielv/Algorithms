package edu.nyu.lx463.questions.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LyuXie on 5/31/17.
 */
public class ZigzagLevelOrder {
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int level = 0;

        while (!deque.isEmpty()) {
            level++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 1) {
                    TreeNode curr = deque.pollLast();
                    result.add(curr.key);
                    if (curr.right != null) {
                        deque.offerFirst(curr.right);
                    }
                    if (curr.left != null) {
                        deque.offerFirst(curr.left);
                    }
                } else {
                    TreeNode curr = deque.pollFirst();
                    result.add(curr.key);
                    if (curr.left != null) {
                        deque.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        deque.offerLast(curr.right);
                    }
                }
            }
        }

        return result;

    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        ZigzagLevelOrder zz = new ZigzagLevelOrder();
        List<Integer> result = zz.zigZag(n1);
        for (int i : result) {
            System.out.print(i);
        }
    }

}
