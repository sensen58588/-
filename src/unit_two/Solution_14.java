package unit_two;

import sun.reflect.generics.tree.FormalTypeParameter;

import java.text.DecimalFormat;
import java.time.format.FormatStyle;
import java.util.Scanner;


public class Solution_14 {

    /**
     * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param:
     * @return:
     */

    public double Power(double base, int exponent) {
        double ans = 0;
        double ex = exponent*1.0;
        ans = Math.pow(base,ex);
        return ans;

    }


    /**
     * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     * 值得注意的是：java本身对负数的存取就是采用2的补码
     * @param:
     * @retuan:
     * @Created by xiaoqiang on 2017/9/12.
     */
    public static int helper(int n){
        int ans = 0;
        String num = null;

        num = Integer.toBinaryString(n);

        char[] arr = num.toCharArray();

        System.out.println("二进制："+num);
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1'){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(helper(n));
    }
}
