package unit_two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 给定整数{a1,a2…an}，判断是否可以从中挑选出若干数，使他们的和恰好为k
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/14.
 */
public class Solution_qunar_1 {

    public static void print(int[]data,int start,int i,int j,boolean key){
        System.out.println("YES");
        if(key){
            for(int ii=start;ii<=i;ii++){
                System.out.print(data[ii]+" ");
            }
            System.out.print(data[j]);
        }else{
            System.out.print(data[j]+" ");
            for(int ii=i;ii>=start;ii--){
                System.out.print(data[ii]+" ");
            }
        }

    }

    public static void helper(int[]data,int k){
        int n = data.length;
        int i=0,j=n-1;
        int value = 0;
        int count =0;
        boolean key = false;
        int start =0;
        while(i<j){ //从前向后
            if(value+data[i]+ data[j] == k){
                print(data,start,i,j,true);
                key=true;
                i++;
                count++;
                break;
            }else if(value +data[i] + data[j]<k){
                value+=data[i];
                i++;
                count++;
            }else if(value +data[i] + data[j]>k){
                i = i-count +1;
                value = 0;
                count = 0;
                start++;
            }
        }
        if(!key){
            //swap
            for(int ii=0;ii<n/2;ii++){
                int temp = data[ii];
                data[ii] = data[j-ii];
                data[j-ii] = temp;
            }
            i=0;
            value=0;
            count=0;
            start =0;
            while(i<j){ //从前向后
                if(value+data[i]+ data[j] == k){
                    print(data,start,i,j,false);
                    key=true;
                    i++;
                    count++;
                    break;
                }else if(value +data[i] + data[j]<k){
                    value+=data[i];
                    i++;
                    count++;
                }else if(value +data[i] + data[j]>k){
                    i = i-count +1;
                    value = 0;
                    count = 0;
                    start++;
                }
            }
        }
        if(!key){
            System.out.println("NO");
        }

    }

    public static void main(String args[]){
        Scanner scanenr = new Scanner(System.in);
        int n = scanenr.nextInt();
        int result = scanenr.nextInt();
        int []data = new int[n];
        for(int i=0;i<n;i++){
            data[i] = scanenr.nextInt();
        }
        Arrays.sort(data);//先排序

        helper(data,result);
    }
}
