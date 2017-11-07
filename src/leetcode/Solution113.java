package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Given the below binary tree and sum = 22,
 * 例如：
 *               5
                / \
               4   8
              /   / \
            11  13   4
          /  \      / \
         7    2    5   1
return
[
[5,4,11,2],
[5,8,4,5]
]

 * @Created by xiaoqiang on 2017/10/27.
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root==null) return res;
        if(root.left==null&&root.right==null){
            temp.add(root.value);
            if(root.value==sum) res.add(temp);
            return res;
        }

        //先把所有的从根节点到叶子结点的路径全部添加
        //左孩子
        List<List<Integer>> leftList = pathSum(root.left,sum-root.value);
        for(int i=0;i<leftList.size();i++){
            leftList.get(i).add(0,root.value); //父节点的值添加在首部
            res.add(leftList.get(i));

        }
        //右孩子
        List<List<Integer>> rightList = pathSum(root.right,sum-root.value);
        for(int i=0;i<rightList.size();i++){
            rightList.get(i).add(0,root.value); //父节点的值添加在首部
            res.add(rightList.get(i));

        }

        //筛选出符合sum值的路径
        for(int i=0;i<res.size();i++){
            int add = 0;
            for(int j=0;j<res.get(i).size();j++){
                add+=res.get(i).get(j);
            }
            if(add!=sum){
                res.remove(i);
            }
        }
        return res;
    }
}

