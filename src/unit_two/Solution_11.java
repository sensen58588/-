package unit_two;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/10.
 */
public class Solution_11 {
    public int JumpFloor(int target) {
        int ans =0;
        if(target<=0) return ans;
        if(target==1) return 1;
        int num1=1,num2=1;
        for(int i=1;i<target;i++){
            ans = num1+num2;
            num1 = num2;
            num2 = ans;
        }

        return ans;
    }
}
