public class Question24 {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;

            if (next != null)
                reverseHead = cur;

            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return reverseHead;
    }

    public ListNode InPlaceReverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseListRecursively(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode cur, ListNode pre) {
        if (cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return helper(next, cur);
    }
}