public class Question25 {
    /**
     *           合并两个排序的链表
     *  输入两个单调递增的链表，输出两个链表合成后的链表，
     *  当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newHead = null;
        if (list1.val <= list2.val) {
            newHead = list1;
            newHead.next = mergeTwoLists(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next = mergeTwoLists(list1, list2.next);
        }
        return newHead;
    }
}
