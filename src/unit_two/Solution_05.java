package unit_two;

/**
 * @Description:  请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/7.
 */
public class Solution_05 {
    //时间效率O(n),额外空间效率O(n)
    public String replaceSpace(StringBuffer str) {
        if(str.length()==0||str==null) return str.toString();
        StringBuffer sb = new StringBuffer();
        String string = str.toString();
        char[] chars = string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                sb.append("%20");
            }else sb.append(chars[i]);
        }
        return sb.toString();
    }

}
