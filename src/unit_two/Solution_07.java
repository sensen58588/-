package unit_two;

/**
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/7.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right =null;
    }
}

public class Solution_07 {

    public static TreeNode helper(int[]pre,int l,int r,int[] in,int i,int j){

        if(l>r||i>j|| r>pre.length-1||j>in.length-1) return null;

        if(l==r||i==j){
            return new TreeNode(pre[l]);
        }

        TreeNode treeNode = new TreeNode(pre[l]);

        int index=0;//根节点位置
        for(int ii=i;ii<=j;ii++){
            if(in[ii]==pre[l]){
                index = ii;
                break;
            }
        }

        treeNode.left = helper(pre,l+1,l+index-i,in,i,index -1);

        treeNode.right = helper(pre,l+index-i+1,r,in,index+1,j);
        return treeNode;
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = helper(pre,0,pre.length-1,in,0,in.length-1);

        return treeNode;
    }

    public static void main(String args[]){
        int[]pre = {1,2,4,7,3,5,6,8};
        int[]in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre,in);

        System.out.println(node.val);
    }


}
