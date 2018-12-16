public class Question23_1 {
    /**
     *  给定一个链表，判断链表中是否有环。
     */
    //leetcode
    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    //剑指Offer
    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head.next;
        if (slow == null)
            return false;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next;

            if (fast != null)
                fast = fast.next;
        }

        return false;
    }
}
