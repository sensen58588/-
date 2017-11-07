package leetcode;

/**
 * @Description: Range Sum Query 2D - Immutable
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/31.
 */
public class Solution304 {

    int[][] matrix;
    int[][] sums;
    public Solution304(int[][] matrix) {
        this.matrix = matrix;
        int x = matrix.length;
        int y = x>0?matrix[0].length:0;
        sums = new int[x+1][y+1];
        initSums();
    }

    //枚举法
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int yStart = col1;
        int res = 0;
        if(row1>row2){
            return res;
        }
        while(row1<=row2){
            if(col1>col2){
                row1++;
                col1 = yStart;
                continue;
            }
            if(row1>row2){
                break;
            }
            res+=matrix[row1][col1];
            col1++;
        }
        return res;
    }

    //优化后，O(1)的算法，建立在O(m*n)的空间上
    public void initSums(){
        for(int i=1;i<sums.length;i++){
            for(int j=1;j<sums[0].length;j++){
                sums[i][j] = matrix[i-1][j-1]+
                        sums[i-1][j]+sums[i][j-1] - sums[i-1][j-1];
            }
        }
    }

    public int betterSumRegion(int row1, int col1, int row2, int col2){
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }

    public static void main(String args[]){

        int[][]test = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}};
        Solution304 vt = new Solution304(test);
        System.out.println(vt.sumRegion(2,1,4,3));
        System.out.println(vt.sumRegion(1,1,2,2));
        System.out.println(vt.sumRegion(1,2,2,4));
        System.out.println("------------------------------------");
        System.out.println(vt.betterSumRegion(2,1,4,3));
        System.out.println(vt.betterSumRegion(1,1,2,2));
        System.out.println(vt.betterSumRegion(1,2,2,4));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

