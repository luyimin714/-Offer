public class Question23 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null)
                return null;
            fast = fast.next.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle)
            return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode meet = hasCycle(head);  //meetingNode(head);

        if (meet == null)
            return null;

        ListNode p1 = meet;

        int len = 1;

        while (p1.next != meet) {
            p1 = p1.next;
            len++;
        }

        p1 = head;
        for (int i = 0; i < len; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private ListNode hasCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return walker;
        }

        return null;
    }

    private ListNode meetingNode(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head.next;
        if (slow == null)
            return null;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast)
                return slow;

            slow = slow.next;
            fast = fast.next;

            if (fast != null)
                fast = fast.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}