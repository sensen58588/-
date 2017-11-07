package guangyu;


/**
 * @Description: 一个整形数组中有正有负，任意两个数相乘，可以得到一个积，求可以得到的最大的积。
    要求比较次数尽可能少，尽量不使用语言自带的容器。·
    例如数组{1,2,5,8，-10，-100,20,20}，返回1000即（-10*-100）
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/18.
 */
public class SolutionOne {

    //快速排序
    public  void quick_sort(int[]source,int left,int right){
        if(left>right){
            return;
        }else{
            int value=source[left];//基准值
            int i,j;
            i=left;
            j=right;

            while(i!=j){
                while(source[j]>=value && j>i){
                    j--;
                }while(source[i]<=value&&i<j){
                    i++;
                }
                if(i<j){
                    int temp=source[i];
                    source[i]=source[j];
                    source[j]=temp;
                }
            }
            if(i==j){
                int temp=source[left];
                source[left]=source[j];
                source[j]=temp;
            }
            quick_sort(source,left,i-1);
            quick_sort(source,i+1,right);
        }
    }

    /*对排好序的数组求最大积
    绝对值最大的数分布在两侧，如果数组条件允许，左侧同为负数，右侧同为正数，判断两侧乘积最大值
    处理情况：数组长度为2，数组全为正数，全为负数， 仅一个正数，仅一个负数等
    */
    public int getResult (int[]array){
        int ans = 0;
        int len = array.length;
        if(len==2){
            ans = array[0]*array[1];
        }else{
            if(len>=2&&array[0]<0&&array[1]<0){
                int temp = array[0]*array[1];
                ans = ans > temp? ans:temp;
            }
            if(len>=2&&array[len-1]>0&&array[len-2]>0){
                int temp = array[len-1]*array[len-2];
                ans = ans > temp? ans:temp;
            }
        }

        return ans;
    }

    public static void main(String args[]){
        int[] array1 = {-3,-2,-1,-21,1,21};
        SolutionOne solutionOne = new SolutionOne();
        //先快速排序
        solutionOne.quick_sort(array1,0,array1.length-1);
        int ans =solutionOne.getResult(array1);
        System.out.println(ans);
    }
}
