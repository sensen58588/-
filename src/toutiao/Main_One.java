package toutiao;

import java.util.Scanner;

/**
 * @Description: 推箱子游戏
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/17.
 */

class Node{
    int i;
    int j;
    public Node(int i,int j){
        this.i = i;
        this.j = j;
    }
}
public class Main_One {
    private  int steps = 0;


    public void moveBox(char[][] map,int a_i,int a_j, int b_i, int b_j){
        tryToMove(map,a_i,a_j,b_i,b_j);//先移动到箱子附近，并计算所需的步数
    }


    //判断b点在a点的什么方向，正上方--1，右上方--2，正右方--3，  右下方--3...以此类推到8个方向上
    public  int getDriection(int a_i,int a_j, int b_i, int b_j){
        int ans = -1;
        if(a_j==b_j&&b_i<a_i){
            ans = 1;
        }else if(a_i>b_i&&a_j<b_j){
            ans = 2;
        }else if(a_i==b_i&&a_j<b_j){
            ans = 3;
        }else if(a_i<b_i&&a_j<b_j){
            ans = 4;
        }else if(a_i<b_i&&a_j==b_j){
            ans = 5;
        }else if(a_i<b_i&&a_j>b_j){
            ans = 6;
        }else if(a_i==b_i&&a_j>b_j){
            ans = 7;
        }else if(a_i>b_i&&a_j>b_j){
            ans = 8;
        }
        return ans;
    }

    //上移
    public boolean moveToUp(char[][] map,int x,int y){
        boolean key = false;
        if(x!=0&&map[x-1][y]!='#'){
            steps++;
            key = true;
        }
        return key;
    }

    //下移
    public boolean moveDown(char[][] map,int x,int y){
        boolean key = false;
        if(x!=map.length-1 &&map[x+1][y]!='#'){
            steps++;
            key = true;
        }
        return key;
    }

    //左移
    public boolean moveLeft(char[][] map,int x,int y){
        boolean key = false;
        if(y!=0&&map[x][y-1]!='#'){
            steps++;
            key = true;
        }
        return key;
    }

    //右移
    public boolean moveRight(char[][] map,int x,int y){
        boolean key = false;
        if(y!=map[0].length-1 &&map[x][y+1]!='#'){
            steps++;
            key = true;
        }
        return key;
    }

    //根据判断的方向去尝试移动
    public  void tryToMove(char[][] map,int a_i,int a_j, int b_i, int b_j){
        int driection = getDriection(a_i,a_j, b_i, b_j);

        //a点已触碰到b点
        if(a_i==b_i&&Math.abs(a_j-b_j)==1){
            return;
        }else if(a_j==b_j&&Math.abs(a_i-b_i)==1){
            return;
        }else{
            if(driection==1){
                if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else{
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }


            }else if(driection==3){
                if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveDown(map,a_i,a_j)){
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }else if(driection==5){
                if(moveDown(map,a_i,a_j)){
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }else if(driection==7){
                if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }if(moveDown(map,a_i,a_j)){
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
                else if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
                else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }
            else if(driection==2){
                if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else{
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }
            else if(driection==4){
                if(moveDown(map,a_i,a_j)){
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }else if(driection==6){
                if(moveDown(map,a_i,a_j)){
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }else if(driection==8){
                if(moveLeft(map,a_i,a_j)){
                    a_j--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveToUp(map,a_i,a_j)){
                    a_i--;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveRight(map,a_i,a_j)){
                    a_j++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }else if(moveDown(map,a_i,a_j)){
                    a_i++;
                    tryToMove(map,a_i,a_j,b_i,b_j);
                }
            }
        }

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] gameMap = new char[n][m];

        Node start = new Node(-1,-1);
        Node box = new Node(-1,-1);
        Node exception = new Node(-1,-1);
        //gameMap init
        for(int i=0;i<n;i++) {
            String data = scanner.next();
            char[] dataArrays = data.toCharArray();
            for (int j = 0; j < m; j++) {
                gameMap[i][j] = dataArrays[j];
                if (dataArrays[j] == 'S') {
                    start = new Node(i, j);
                }
                if (dataArrays[j] == '0') {
                    box = new Node(i, j);
                }
                if (dataArrays[j] == 'E') {
                    exception = new Node(i, j);
                }
            }
        }
        Main_One ma = new Main_One();
        ma.moveBox(gameMap,start.i,start.j,box.i,box.j);
        if(ma.steps==0){
            System.out.println(-1);
        }else{
            System.out.println(ma.steps);
        }
    }
}
