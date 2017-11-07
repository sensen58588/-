package mySolution;

import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/28.
 */
public class SolutionOne {

    public static boolean isLetter(char ch){
        return ch>='A'&&ch<='Z';
    }

    public static String helper(String string){
        char[] arr = string.toCharArray();
        StringBuffer sb = new StringBuffer();
        int start = 0;
        int end = 0;
        int startIndex = 0;
        int endIndex = 0;
        int index = 0;
        int count = 0;
        int preCount = 0;
        if(!containsNum(arr)){
            return "-1";
        }

        while(index < arr.length){

            if(index+2<arr.length&&arr[index]=='R'&&arr[index+1]=='E'&&arr[index+2]=='D'){
                index+=3;
            }

            //数字
            else if(!isLetter(arr[index])&&index+1<arr.length){
                endIndex = index;
                index++;
                count++;

            }
            else if(!isLetter(arr[index])&&index+1>=arr.length){
                end = index;
                index++;
            }
            //不是RED的字母
            else if(isLetter(arr[index])&&index+1<arr.length){
                if(count>=preCount){
                    start = startIndex;
                    end = endIndex;
                }

                startIndex = index+1;
                preCount = Math.max(preCount,count);
                count = 1;
                index++;
            }
            else if(isLetter(arr[index])&&index+1>=arr.length){
                if(count>=preCount){
                    start = startIndex;
                    end = endIndex;
                }
                break;
            }


        }

        for(int i = start;i<=end;i++){
            if(!isLetter(arr[i])) sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static boolean containsNum(char[]arr){
        for(int i=0;i<arr.length;i++){
            if(!isLetter(arr[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        String ans = helper(string);
        System.out.println(ans);
    }
}
