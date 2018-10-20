public class Question23 {
    private ListNode MeetingNode (ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head.next;
        if (slow == null)
            return null;

        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;

            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode meetingNode = MeetingNode(head);
        if (meetingNode == null)
            return null;

        int nodesInLoop = 1;
        ListNode p1 = meetingNode;
        while (p1.next != meetingNode) {
            p1 = p1.next;
            nodesInLoop++;
        }

        p1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
