package unit_two;

import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/11.
 */
public class Solution_renren_1 {

    public  static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans =0;
        ans = 1+(n*(n-1));
        if(n<=1) System.out.println(0);
        else System.out.println(ans);
    }
}
