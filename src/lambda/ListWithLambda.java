package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/29.
 */
public class ListWithLambda {

    public static void main(String args[]){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages,(str)->str.toString().startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));
    }

    public static void filter(List<String> list, Predicate predicate){
        for(String name:list){
            //过滤
            if(predicate.test(name)){
                System.out.println(name+" ");
            }
        }
    }
}
