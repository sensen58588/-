package mySolution;

import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/28.
 */
public class SolutionTwo {
    public static char[] reverse(char[]arr,int l,int r){
        for(int i=l;i<(l+r)/2;i++){
            char temp = arr[l];
            arr[l] = arr[r-i];
            arr[r-i] = temp;
        }
        return arr;
    }

    public static void helper(String string,int k){
         int len =string.length();
         char[]arr = string.toCharArray();
         int count = 0;
         int start = 0;
         int end = -1;
         while(len-count>2*k){
             start = end+1;
             if(end ==-1) end = 0;
             end += k-1;
             arr = reverse(arr,start,end);
             count+=2*k;
         }
         if(len - count>=k&&len-count<2*k){
             start = end+1;
             end += k-1;
             arr = reverse(arr,start,end);
             count+=k;
         }
         else if(len-count<k){
             start = end +1;
             end = len-1;
             arr = reverse(arr,start,end);
         }

         for(int i=0;i<arr.length;i++){
             System.out.print(arr[i]);
         }

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int k = scanner.nextInt();
        helper(string,k);

    }
}
