import java.util.Stack;

public class Question6 {
    public static void PrintListReverselyIteratively(ListNode head){
        Stack<ListNode> stack = new Stack<>();

        ListNode p = head;
        while(p != null){
            stack.push(p);
            p = p.next;
        }

        while (!stack.empty()){
            p = stack.peek();
            System.out.println(p.val);
            stack.pop();
        }
    }

    public static void PrintListReverselyRecursively(ListNode head){
        if (head != null){
            if (head.next != null){
                PrintListReverselyRecursively(head.next);
            }
            System.out.println(head.val);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int n = 0;
        while (n++ < 10){
            p.next = new ListNode(n);
            p = p.next;
        }
//        p = head;
//        while (p != null){
//            System.out.print(p.val);
//            p = p.next;
//        }
        PrintListReverselyRecursively(head);
        PrintListReverselyIteratively(head);
    }
}
