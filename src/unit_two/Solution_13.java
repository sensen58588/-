package unit_two;


/**
 * @Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @param: int
 * @retuan: int
 * @Created by xiaoqiang on 2017/9/10.
 */
public class Solution_13 {
    public int RectCover(int target) {
        int ans = 0;
        if(target<=0) return 0;
        if(target==1) return 1;
        if(target==2) return 2;
        ans = RectCover(target-1)+RectCover(target-2);
        return ans;
    }
}
