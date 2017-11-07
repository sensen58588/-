package leetcode;

/**
 * @Description: 判断两棵二叉树是否相等
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/26.
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.value!=q.value) return false;
        if(p.value==q.value){
            boolean leftKey = isSameTree(p.left,q.left);
            boolean rightKey = isSameTree(p.right,q.right);
            return leftKey==true&&rightKey==true;
        }
        else return false;
    }
}
