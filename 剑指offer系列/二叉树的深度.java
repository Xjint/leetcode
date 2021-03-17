package 剑指offer系列;

import java.util.ArrayDeque;
import java.util.Deque;

import base.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度
 * 
 */
public class 二叉树的深度 {
    // 递归
    // public int maxDepth(TreeNode root) {
    // if(root == null){
    // return 0;
    // }
    // int left = maxDepth(root.left);
    // int right = maxDepth(root.right);
    // return 1 + Math.max( left,right);
    // }
    // 迭代
    public int maxDepth(TreeNode root) {
        int deep = 0;
        if (root == null) {
            return deep;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = deque.poll();
                if (temp.left != null) {
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                }
            }
            deep++;
        }
        return deep;
    }
}
