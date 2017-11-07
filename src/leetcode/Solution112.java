package leetcode;

/**
 * @Description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/26.
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        int value = root.value;

        if(root.left==null&&root.right==null&&sum==value) return true;
        if(hasPathSum(root.left,sum-value)) return true;
        if(hasPathSum(root.right,sum-value)) return true;

        return false;

    }
}
