package unit_two;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 输入一个链表，从尾到头打印链表每个节点的值
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/7.
 */
public class Solution_06 {

    class ListNode{

        int val;
        ListNode next = null;

        ListNode(int val) {
           this.val = val;
        }

    }

    //解法一：遍历，赋值再交换...
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            System.out.println();
            return list;
        }
        while(listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }


        int len = list.size();
        for(int i=0;i<list.size()/2;i++){
            int temp = list.get(i);
            list.set(i,list.get(len-1));
            list.set(len-1,temp);
            len--;
        }

        return list;
    }

    //解法二：使用栈
    public ArrayList<Integer> printFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode==null) return list;
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (stack.empty()!=true){
            list.add(stack.pop());
        }

        return list;
    }
}
