public class Question18 {
    public void DeleteNode(ListNode head, ListNode delete) {
        if (head == null || delete == null)
            return;

        if (delete.next != null) {
            ListNode next = delete.next;
            delete.val = next.val;
            delete.next = next.next;

            next = null;
        } else if (head == delete) {
            delete = null;
            head = null;
        } else {
            ListNode node = head;
            while (node.next != delete) {
                node = node.next;
            }
            node.next = null;
            delete = null;
        }
    }
}