public class Question22 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
