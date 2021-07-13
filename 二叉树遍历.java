import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import base.TreeNode;

public class 二叉树遍历 {
    // 后序遍历
    public void hou(TreeNode root) {

    }

    // 前序遍历
    public List<Integer> qian(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.value);
                stack.push(node);
                node = node.left;
            }
            // 走到这里说明遍历到了最左边
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    // 中序遍历
    public static List<Integer> zhong(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 走到这里说明遍历到了最左边
            node = stack.pop();// 跟
            list.add(node.value);
            node = node.right;
        }
        return list;
    }
}
