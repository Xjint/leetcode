import base.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

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

  //二叉树层序遍历(从左到右)
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    if (root == null){
      return new ArrayList<>();
    }
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> level;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      level = new ArrayList<>();
      for (int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();
        level.add(node.value);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      ans.add(level);
    }
    return ans;
    // write code here
  }
}
