package leetcode;

/**
 * @Description: Invert a binary tree.
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/25.
 */
public class Solution226 {
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        swap(root);
        return root;
    }

}
