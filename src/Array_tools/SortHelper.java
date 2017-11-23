package Array_tools;

public class SortHelper {
    //提供一些数组的方法
    //打印数组
    public void print(int[] a){
        for(int i =0;i<a.length;i++){
            System.out.print("("+a[i]+")");
        }
        System.out.println();
    }

    //创建随机数组
    public int[] createIntArrays(int length,int start,int end){
        int[] arr = new int[length];
        if(start>end){
            int value = start;
            start = end;
            end = value;
        }
        int temp = end - start;
        for(int i =0;i<length;i++){
            int rand = (int)(Math.random()*temp);
            arr[i] = start+rand;
        }

        return arr;
    }

    //创建二维随机数组
    public int[][] createIntArrays(int len_i,int len_j,int start,int end){
        int[][]arr = new int[len_i][len_j];
        if(start > end){
            int value = start;
            start = end;
            end = value;
        }
        int temp = end - start;
        for(int i =0;i<len_i-1;i++){
            for(int j=0;j<len_j-1;j++){
                int rand = (int)(Math.random()*temp);
                arr[i][j] = start+rand;
            }

        }
        return arr;
    }

    public void print(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print("("+arr[i][j]+")");
            }
            System.out.println();
        }
    }
}
