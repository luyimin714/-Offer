public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode cur = head;
        ListNode dummy = cur;

        System.out.println(dummy.val);
        cur = cur.next;
        System.out.println(dummy.val);
        System.out.println(cur.val);
    }
}
