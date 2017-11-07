package unit_two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/14.
 */
public class meituan_1 {


    //把a放在b前面
    public static boolean judge(long a, long b){
        boolean key = false;
        long ans = 0;

        String aa = a+""+b;
        ans = Long.parseLong(aa);
        System.out.println("trans: "+a+"  "+b+"  ---> "+ans);
        if(ans%7==0){
            key = true;
        }
        return key;
    }

    public static void helper(long[]data){
        if(data.length==1){
            if(data[0]%7==0){
                System.out.println(1);
                return;
            }
        }
        int count = 0;//计数器
        for(int i=0;i<data.length-1;i++){

            for(int j=i+1;j<data.length;j++){
                if(judge(data[i],data[j])) count++;
                if(judge(data[j],data[i])) count++;
            }
        }
        System.out.println(count);

    }


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[]data = new long[n];
        for(int i=0;i<n;i++){
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        helper(data);
    }
}
