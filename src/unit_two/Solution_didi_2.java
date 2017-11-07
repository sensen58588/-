package unit_two;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: 因子只包含2，3，5-----1也是
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/10.
 */
public class Solution_didi_2 {
    public static int helper(int n){
        int ans =0;
        if(n<=0) return ans;
        ArrayList<Integer> list = new ArrayList<>();
        int count =1;
        list.add(1);
        int min=0;
        int i=0,j=0,k=0;
        while(count<n){
            min = Math.min(Math.min(list.get(i)*2,list.get(j)*3),list.get(k)*5);
            count++;
            list.add(min);
            if(min==list.get(i)*2) i++;
            if(min==list.get(j)*3) j++;
            if(min==list.get(k)*5) k++;
        }
        ans = list.get(n-1);
        return ans;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = helper(n);
        System.out.println(ans);

    }
}
