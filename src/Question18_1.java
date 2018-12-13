public class Question18_1 {
    /****************************************************************
     *  删除链表中重复的结点
     *  在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     *  重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
     *  处理后为 1->2->5
     ****************************************************************/
    //leetcode
    public ListNode deleteDuplicates2(ListNode pHead) {
        if(pHead == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pHead;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur=cur.next;
            }
            if (pre.next == cur) { //不是重复节点
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }

    //剑指offer
    public ListNode deleteDuplicates(ListNode pHead) {
        if (pHead == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode cur = pHead;
        ListNode pre = dummy;

        while (cur != null) {
            ListNode next = cur.next;
            boolean needDelete = false;

            if (next != null && cur.val == next.val)
                needDelete = true;

            if (!needDelete) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode delete = cur;
                int val = delete.val;
                while (delete != null && delete.val == val) {
                    next = delete.next;
                    delete = next;
                }
                pre.next = next;
                cur = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
        Question18_1 test = new Question18_1();
        head = test.deleteDuplicates(head);
        cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }
}
