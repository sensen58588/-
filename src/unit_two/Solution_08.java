package unit_two;

import java.util.Stack;

/**
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/7.
 */
public class Solution_08 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if(stack2.size()!=0) return stack2.pop();
        while(stack1.size()!=0){
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }
}
