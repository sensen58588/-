package unit_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/17.
 */
public class Solution_Souhu {

    public static void helper(long n){

    }


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        long n =scanner.nextLong();
        if(n<=0){
            return;
        }
        long min = Long.MIN_VALUE;
        long max =Long.MAX_VALUE;
        long value1 =0;//记录最大值
        long value2 =0;
        for(long i=0;i<n;i++){
            long current_value = scanner.nextLong();
            if(min<current_value&&current_value<max){
                if(current_value>value1){
                    value2 = value1;
                    value1 = current_value;
                }
            }

        }
        if(n>2&&value2==0){
            value2 =value1;
        }
        System.out.println(value2);

        /*ArrayList<Long> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(scanner.nextLong());
        }
        Collections.sort(list);
        long ans =0;
        long temp = list.get(n-1);
        for(int i=n-1;i>0;i--){
            if(list.get(i)==temp) continue;
            else ans =list.get(i);break;
        }
        System.out.println(ans);*/

    }
}
