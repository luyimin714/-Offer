import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question6 {
    /*
     * 从尾到头打印链表
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */
    //迭代
    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!stack.empty()) {
            res.add(stack.pop().val);
        }
        return res;
    }
    //递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, head);
        return res;
    }

    private void helper(ArrayList<Integer> res, ListNode cur) {
        if (cur != null) {
            if (cur.next != null) //不加也可以
                helper(res, cur.next);
            res.add(cur.val);
        }
    }
}
