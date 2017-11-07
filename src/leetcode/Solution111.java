package leetcode;

/**
 * @Description: Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/25.
 */
/*  Definition for a binary tree node.
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }*/
public class Solution111 {
    int ans = 0;
    public int minDepth(TreeNode root) {
        if(root==null){
            return ans;
        }
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        ans = Math.min(minLeft,minRight)+1;
        return ans;
    }
}
