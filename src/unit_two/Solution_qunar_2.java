package unit_two;

import java.util.Scanner;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/14.
 */

class P_Node{
    String name;
    String friend_name;
    P_Node friend;
}

public class Solution_qunar_2 {



    public static void main(String args[]){
        Scanner scanenr = new Scanner(System.in);
        int P = scanenr.nextInt();
        int R = scanenr.nextInt();
        String[] refer = new String[R*2+1];
        for(int i=1;i<refer.length;i++){
            refer[i] =scanenr.next();
        }

    }
}
