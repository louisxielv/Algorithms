package edu.nyu.lx463.questions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LyuXie on 7/29/17.
 */
public class CheckIfATreeIsComplete {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                flag = true;
            }else if (flag){
                return false;
            }else {
                queue.offer(node.left);
            }

            if (node.right == null) {
                flag = true;
            }else if (flag){
                return false;
            }else {
                queue.offer(node.right);
            }
        }
        return true;
    }
}
