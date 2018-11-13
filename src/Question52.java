public class Question52 {
    /*
     *       两个链表的第一个公共结点
     * 输入两个链表，找出它们的第一个公共结点。
     */

    /*
     * 解法1
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    /*
     * 解法2
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        int lengthDif = lengthA - lengthB;

        ListNode headLong = headA;
        ListNode headShort = headB;
        if (lengthB > lengthA) {
            headLong = headB;
            headShort = headA;
            lengthDif = lengthB - lengthA;
        }

        for (int i = 0; i < lengthDif; i++)
            headLong = headLong.next;

        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }

        return headLong;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }
}
