package leetcode;

/**
 * @Description: find how many paths from node1 to  node2,and node1 must be node2's father or grand father ...
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/28.
 */
public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int value = 0;
        if(root.value==sum) value=1;
        int hasRoot = findPath(root,sum);
        int leftRoot = pathSum(root.left,sum);
        int rightRoot = pathSum(root.right,sum);
        return hasRoot+leftRoot+rightRoot+value;

    }

    public int findPath(TreeNode root,int sum){
        if(root==null) return 0;
        int res = 0;

        //如果当前节点的值已经满足sum，res+1，但是他的孩子路径上的和为0话，相当于另外一条合法路径
        if(root.value==sum) res = 1;
        res += findPath(root.left,sum-root.value)+findPath(root.right,sum-root.value);
        return res;
    }
}
