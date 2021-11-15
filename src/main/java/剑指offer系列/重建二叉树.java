package 剑指offer系列;

import base.TreeNode;
import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class 重建二叉树 {

    // 前序遍历根左右 中序遍历左根右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, n),
                Arrays.copyOfRange(inorder, rootIndex + 1, n));
        return root;
    }
}
