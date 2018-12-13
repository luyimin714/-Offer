public class Question18 {
    /*
     * 在O(1)时间内删除链表节点
     * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
     */
    public void DeleteNode(ListNode head, ListNode delete) {
        if (head == null || delete == null) return;

        if (delete.next != null) { //要删除的节点不是尾节点
            ListNode next = delete.next;
            delete.val = next.val;
            delete.next = next.next;
            next = null;
        } else if (head == delete) { //链表只有一个节点，删除头节点
            delete = null;
            head = null;
        } else { //链表中有多个节点，删除尾节点
            ListNode node = head;
            while (node.next != delete) {
                node = node.next;
            }
            node.next = null;
            delete = null;
        }
    }
}