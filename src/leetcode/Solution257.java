package leetcode;

import java.util.List;
import java.util.Vector;

/**
 * @Description: Given a binary tree, return all root-to-leaf paths.
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/27.
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new Vector<>();
        if(root==null) return res;

        //递归终止条件是节点为叶子节点
        if(root.left==null&&root.right==null) {
            res.add(String.valueOf(root.value));
            return res;
        }

        //左节点下的所有路径
        List<String> leftS = binaryTreePaths(root.left);

        //为每个路径前加上父节点的 value->
        for(int i=0;i<leftS.size();i++){
            res.add(root.value+"->"+leftS.get(i));
        }

        //右节点下的所有路径
        List<String> rightS = binaryTreePaths(root.right);
        for(int i=0;i<rightS.size();i++){
            res.add(root.value+"->"+rightS.get(i));
        }
        return res;

    }
}
