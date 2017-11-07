package leetcode;


/**
 * @Description: Validate Binary Search Tree
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/29.
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
  /*      boolean key = true;
        if(root.left!=null){
            if(root.value<root.left.value) key = false;
        }
        if(root.right!=null){
            if(root.value>root.right.value) key = false;
        }

        boolean leftKey = isValidBST(root.left);
        boolean rightKey = isValidBST(root.right);

        return key&&leftKey&&rightKey;*/
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if(root==null) return true;
        if(root.value<=minVal||root.value>=maxVal) return false;
        return isValidBST(root.left,minVal,root.value)&&isValidBST(root.right,root.value,maxVal);
    }

}
