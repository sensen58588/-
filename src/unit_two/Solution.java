package unit_two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 查找数组中第二大的元素
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/17.
 */
public class Solution {


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        if(n<=1){
            System.out.println(0);
            return;
        }
        long []arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextLong();
        }

        long ans =0;
        Arrays.sort(arr);
        long temp = arr[n-1];
        for(int i=n-1;i>0;i--){
            if(arr[i]==temp) continue;
            else ans =arr[i];break;
        }
        System.out.println(ans);
    }
}
