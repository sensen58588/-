package unit_two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 对数组分组，每组亦或结果为0
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/10.
 */
public class Solution_didi_1 {

    public static void helper(int[]data){
        Arrays.sort(data);
        int count=0;
        int key =1;
        for(int i=0;i<data.length-1;i++){
            if(data[i]==0){
                count++;
                continue;
            }else if(data[i]==data[i+1]){
                key++;
            }


        }

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]data = new int[n];
        for(int i=0;i<n;i++){
            data[i] = scanner.nextInt();
        }
        helper(data);
    }
}
