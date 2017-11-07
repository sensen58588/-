package unit_two;

/**
 * @Description: 字符串匹配问题 例如：abc_123_33 grep"abc*_33"成功，“abc_*2_*33”失败
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/15.
 */
public class String_match {

    public static boolean match(String str,String grep){
        boolean key = true;
        char[]arr = str.toCharArray();
        char[]gre = grep.toCharArray();

        int j=0;//gre的位置指针
        for(int i=0;i<arr.length;i++){
            char get_gre = gre[j];
            if(get_gre!='*'&&get_gre==arr[i]){
                j++;
                continue;
            }else if(get_gre=='*'){
                if(j<gre.length){
                    get_gre = gre[++j]; //获取*下一个的元素

                    i++;
                    while(i<arr.length && arr[i]!=get_gre){

                        i++;
                    }
                    get_gre = gre[++j];
                    if(i==arr.length){
                        key = false;
                        break;
                    }

                }else{
                    break;
                }
            }else {
                key = false;
                break;
            }

        }


        return key;
    }

    public static void main(String args[]){
        String str = "abc_123_33";
        String grep = "abc*_33";
        String grep1 = "abc*4_*33";

        System.out.println(match(str,grep));
        System.out.println(match(str,grep1));

    }

}
