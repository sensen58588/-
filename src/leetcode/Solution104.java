package leetcode;

/**
 * @Description: Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest
 path from the root node down to the farthest leaf node
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/25.
 */

class TreeNode{
    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value){
        this.value = value;
    }
}

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}
