package unit_two;

import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/14.
 */
public class Solution_qunar_3 {

    public static int foresee(char[][]pos,int ii,int jj){
        int nums = 0;
        if(ii-1>=0&&pos[ii-1][jj]!='x'){
            nums++;
        }
        if(ii+1<pos.length&&pos[ii+1][jj]!='x'){
            nums++;

        }
        if(ii-1>=0&&jj-1>=0&&pos[ii-1][jj-1]!='x'){
            nums++;

        }
        if(ii+1<pos.length&&jj-1>=0&&pos[ii+1][jj-1] != 'x'){
            nums++;
        }

        return nums;
    }

    public static int leaft(char[][]pos,int ii,int jj){
        int nums = 0;

        if(ii-1>=0){
            nums++;
            pos[ii-1][jj] = 'x';
        }
        if(ii+1<pos.length){
            nums++;
            pos[ii+1][jj] ='x';
        }
        if(ii-1>=0&&jj-1>=0){
            nums++;
            pos[ii-1][jj-1]='x';
        }
        if(ii+1<pos.length&&jj-1>=0){
            nums++;
            pos[ii+1][jj-1] = 'x';
        }


        return nums;
    }

    public static void helper(char[][]pos){
        int number = 1;
        for(int i=0;i<pos.length;i++){
            for(int j=0;j<pos[0].length;j++){
                if(pos[i][j]=='x') continue;
                int leaft = foresee(pos,i,j);
                if((j+1<pos[0].length && leaft<=foresee(pos,i,j+1))
                        &&(i+1<pos.length &&leaft<=foresee(pos,i+1,j))){
                    number++;
                    pos[i][j]='x';
                    leaft(pos,i,j);
                }else if(j+1==pos[0].length||i+1==pos.length){
                    number++;
                    pos[i][j]='x';
                    leaft(pos,i,j);
                }
            }
        }

        System.out.println(number);

    }

    public static void main(String args[]){
        Scanner scanenr = new Scanner(System.in);
        int M = scanenr.nextInt();//行
        int N = scanenr.nextInt();//列
        char[][] pos = new char[M][N];
        for(int i=0;i<M;i++){
            String str = scanenr.next();
            char[] arr =str.toCharArray();
            for(int j=0;j<N;j++){
                pos[i][j]=arr[j];
            }
        }

        helper(pos);
    }
}
