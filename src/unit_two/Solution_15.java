package unit_two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 简单数学：数字黑洞，给一个四位的正整数n，按照非递增顺序排序得到A，再按照非递减顺序排列得到B，
 * n =  A - B,然后依次往下计算，最终会得到6174这个数（或者0）
 * @param: int
 * @retuan:
 * @Created by xiaoqiang on 2017/9/14.
 */
public class Solution_15 {

    public static int[] trans_to_arr(int n){
        String str_n = n+"";
        char[] nums = str_n.toCharArray();
        int[] ans = new int[4];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i] - 48;
        }
        return ans;
    }

    public static void helper(int n){
        if (n==6174) return;
        int[] data = trans_to_arr(n);
        Arrays.sort(data);
        int min = data[0]*1000+data[1]*100+data[2]*10+data[3];
        int max = data[0]+data[1]*10+data[2]*100+data[3]*1000;
        if(max-min==0){
            System.out.println(max+"-"+min+"="+(max-min));
            return;
        }else{
            System.out.println(max+"-"+min+"="+(max-min));
            helper(max-min);
        }

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        helper(n);

    }
}
