package 剑指offer系列;

import java.util.ArrayDeque;
import java.util.Deque;

import base.TreeNode;

/**
 * 
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。 Definition for a binary tree node. public class
 * TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x;
 * } }
 */
public class 二叉树的镜像 {
    // 递归
    // public TreeNode mirrorTree(TreeNode root) {
    // if (root == null) {
    // return root;
    // }
    // TreeNode temp = root.left;
    // root.left = root.right;
    // root.right = temp;
    // mirrorTree(root.right);
    // mirrorTree(root.left);
    // return root;
    // }
    // 迭代
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null)
                deque.push(node.left);
            if(node.right != null)
                deque.push(node.right);
        }
        return root;
    }
}
