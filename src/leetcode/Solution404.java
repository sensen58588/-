package leetcode;

/**
 * @Description: Find the sum of all left leaves in a given binary tree.
 * 注意是左叶子，而不是左节点
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/26.
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        /* 计算的是左节点
        if(root==null) return 0;
        if(root.left==null) return 0;
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+root.left.value;*/

        if(root==null) return 0;
        int value = 0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null) value+=root.left.value;
        else{
            value+=sumOfLeftLeaves(root.left);
        }
        value+=sumOfLeftLeaves(root.right);
        return value;
    }
}
