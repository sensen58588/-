package leetcode;

/**
 * @Description: Lowest Common Ancestor of a Binary Search Tree
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/29.
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null) return null;

        /*//确定p比q小
        if(p.value>q.value){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if(root.value>=p.value&&root.value<=q.value) return root;
        if(p.value>root.value) return lowestCommonAncestor(root.right,p,q);
        else{
            return lowestCommonAncestor(root.left,p,q);
        }*/

        if(root.value>p.value&&root.value>q.value) return lowestCommonAncestor(root.left,p,q);
        if(root.value<q.value&&root.value<p.value) return lowestCommonAncestor(root.right,p,q);
        return root;
    }

}
