package unit_two;

/**
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/7.
 */
public class Solution_09 {
    public int minNumberInRotateArray(int [] arr) {
        int len =arr.length;
        if(len==0) return 0;

        int l = 0;//左指针
        int r = arr.length-1;//右指针
        int index = l;
        int temp = arr[l];
        while(arr[l]>=arr[r]){
            if(r-l==1){
                index = r;
                break;
            }
            index = (l+r)/2;
            if(arr[index]>=arr[l]){
                l = index;
            }else if(arr[index]<=arr[r]) r = index;
        }
        return arr[index];

    }
}
