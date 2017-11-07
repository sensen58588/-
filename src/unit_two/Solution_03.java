package unit_two;

import Array_tools.SortHelper;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
* @Description: 找出数组中重复的数字,length:n ,数字的范围在0到n-1内，找到任意一个重复的数字即可
* @param: int[]
* @return: int
*/

public class Solution_03 {

    //最初的思路：开辟足够大的空间，时间效率O(n)
    public static int helper1(int []data){
        int ans = -1;
        char []temp = new char[data.length];
        for(int i=0;i<temp.length;i++){
            temp[i] ='a'; //出现0次
        }
        for(int i=0;i<data.length;i++){
            if(data[i]<0) break;
            if (temp[data[i]]=='a'){
                temp[data[i]] = 'b'; //出现1次
            }
            if(temp[data[i]]=='b') ans = data[i];
        }

        return ans;
    }

    //先对数组进行排序,时间效率O(n*log(n))
    public static int arr_sort(int []data){

        Arrays.sort(data);

        int ans = -1;
        for(int i=0;i<data.length;i++){
            if(data[i]<0) break;
            if(i+1<data.length && data[i]==data[i+1]){
                ans = data[i];
                break;
            }
        }
        return ans;

    }

    //优化最初的思路，使用哈希表, O(n)
    public static int hash_set(int []data){

        int ans = -1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<data.length;i++){
            if(data[i]<0) break;
            if(set.contains(data[i]))
            {
                ans = data[i];
                break;
            }else set.add(data[i]);

        }
        return ans;
    }


    public static void main(String args[]){
        int[]data = (new SortHelper()).createIntArrays(10,1,10);
        Long start_time_1 = System.currentTimeMillis();

        int value = helper1(data);

        Long start_time_2 = System.currentTimeMillis();

        int value2 = hash_set(data);

        Long start_time_3 = System.currentTimeMillis();


        int value3 = arr_sort(data);

        Long start_time_4 = System.currentTimeMillis();

        double time_1 = (double)(start_time_2 - start_time_1)/1000;
        double time_2 = (double)(start_time_3 - start_time_2)/1000;
        double time_3 = (double)(start_time_4 - start_time_3)/1000;
        System.out.println(value+"helper1()_Runtime:  "+time_1+"s");
        System.out.println(value2+"hash_set()_Runtime:  "+time_2+"s");
        System.out.println(value3+"arr_sort()_Runtime:  "+time_3+"s");
    }
}
