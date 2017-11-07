package unit_two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 第一行包含两个整数N,M,K，表示矩阵的规模以及金币的数目。
2>=N,M<=100，0<=K<=1000
接下来行每行包含两个整数，表示第个金币的位置，位于从上往下第行，从左往右第列。
1<=Xi<=N,1<=Yi<=M
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/11.
 */
class Node implements Comparable<Node>{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if(this.x !=o.x) return this.x - o.x;
        else return this.y -o.y;
    }
}

public class Solution_renren_2 {

    public static boolean charge(List<Node> list){
        boolean key = true;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).x>list.get(i+1).x&&list.get(i).y<list.get(i+1).y) {
                key = false;
                break;
            }
        }
        return key;
    }

    public static void helper(List<Node>list,int size_x,int size_y){
        //初始位置
        int x = 1, y = 1;

        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<list.size();i++){
            Node get_node = list.get(i);
            while(x<get_node.x||y<get_node.y){
                if(x==get_node.x&&y<get_node.y){
                    y++;
                    stringBuffer.append("R");
                }else if(x<get_node.x){
                    x++;
                    stringBuffer.append("D");
                }
            }
        }
        while(x<size_x||y<size_y){
            if(x==size_x && y<size_y){
                y++;
                stringBuffer.append("R");
            }else if(x<size_x){
                x++;
                stringBuffer.append("D");
            }
        }
        System.out.println(stringBuffer.toString());
    }


    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int size_x = scanner.nextInt();
        int size_y = scanner.nextInt();
        int num = scanner.nextInt();
        List<Node> list= new ArrayList<>();
        int i=0;
        boolean key = true;
        while(i<num){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(x>size_x||y>size_y){
                key=false;
                break;
            }
            list.add(new Node(x,y));
            i++;
        }

        if(!charge(list)&&key) System.out.println("Impossible");
        else helper(list,size_x,size_y);

    }
}
