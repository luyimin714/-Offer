public class Question23 {
    /*
     * 链表中环的入口结点
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    //leetcode
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;

            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;

        //slow从头开始走,fast从相遇的节点开始走，刚好会在入口节点处相遇
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    //剑指offer
    public ListNode detectCycle2(ListNode head) {
        ListNode meet = meetingNode(head);  //hasCycle(head)

        if (meet == null)
            return null;

        //得到环中节点的数目
        int len = 1;
        ListNode p1 = meet;
        while (p1.next != meet) {
            p1 = p1.next;
            len++;
        }
        //先移动p1,次数为环中节点的数目
        p1 = head;
        for (int i = 0; i < len; i++) {
            p1 = p1.next;
        }
        //再移动p1和p2
        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
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
}