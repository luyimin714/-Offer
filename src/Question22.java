public class Question22 {
    /**
     * 链表中倒数第k个结点
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= k - 1; i++) {  //从头节点开始跳，跳k - 1步, k - 1是fast节点和slow节点之间的间隔
            if (fast.next == null)
                return null;
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 1; i <= n; i++) {  //fast节点和slow节点之间的间隔为n，比上面多一个节点，使得slow节点
            if (fast.next == null)      //恰好位于待删除节点的前面
                return null;
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
