package unit_two;

import Array_tools.SortHelper;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @Description: 二维数组中的查找，数组中，arr[][i]<=arr[][i+1] arr[j][] < arr[j+1][]
 * @param: int
 * @retuan: boolean
 * @Created by xiaoqiang on 2017/9/6.
 */
public class Solution_04 {


    //暴力破解，枚举法, O(i*j),未使用数组序列的特性
    public static boolean enumerate(int[][]arr,int value){
        boolean key =false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==value) {
                    key =true;
                    break;
                }
            }
        }

        return key;
    }

    //排除查找法,从数组的右上角开始比较，排除一行或一列
    public static boolean binary_serch(int[][] arr,int value){
        boolean key = false;

        if(arr.length==0||arr[0].length==0) return key;

        int i = 0;
        int j = arr[0].length-1;

        int temp = arr[i][j];//右上角的值
        while(i<=arr.length-1 && j>=0&&temp != value){
            if(temp > value) j--;
            else i++;
            if(i>arr.length-1||j<0) break;
            temp = arr[i][j];
        }
        if(temp==value) key = true;

        return key;
    }

    //测试
    public static void main(String args[]){
        SortHelper sortHelper = new SortHelper();
        int[][]data = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        sortHelper.print(data);

        System.out.println(binary_serch(data,6));
        System.out.println(enumerate(data,6));
    }
}
