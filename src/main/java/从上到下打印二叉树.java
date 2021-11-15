import base.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树 {
    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * 
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i++) {
                node = queue.poll();
                list.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
