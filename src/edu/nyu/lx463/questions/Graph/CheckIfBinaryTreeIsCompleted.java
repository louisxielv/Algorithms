package edu.nyu.lx463.questions.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LyuXie on 4/15/17.
 */
public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right != null) {
                return false;
            } else if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                while (!queue.isEmpty()) {
                    TreeNode curr = queue.poll();
                    if (curr.left != null || curr.right != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
