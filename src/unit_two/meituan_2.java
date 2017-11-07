package unit_two;

import java.util.Scanner;

/**
 * @Description: Alice 首先操作。在每一次操作中，轮到操作的人需要选择一个点亮的灯泡，
 * 然后把它以及它右边的所有灯泡的状态进行一次改变，即把点亮的灯泡熄灭，把熄灭的灯泡点亮。
 * 如果在某一个人操作完之后，所有的灯泡都变成了熄灭状态，
 * 那么那个人就赢得了游戏。Alice 和 Bob 都想赢得游戏，在他们都足够聪明的情况下，最后谁会赢呢？
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/14.
 */
public class meituan_2 {

    //一次操作
    public static void turn(int[]data,int pos){
        for(int i=pos;i<data.length;i++){
            if(data[i]==1) data[i]=0;
            else data[i]=1;
        }
    }

    //检查
    public static boolean leaft(int[]data){
        boolean key =true;
        for(int i=0;i<data.length;i++){
            if(data[i]!=0) key =false;
        }
        return key;
    }

    public static void helper(int[]data){
        int count =1;
        for(int i=0;i<data.length;i++){
            if(data[i]==0) continue;
            else{
                turn(data,i);
                if(leaft(data)) break;
                else count++;
            }
        }
        if(count%2==0){
            System.out.println("Bob");
        }else System.out.println("Alice");

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
