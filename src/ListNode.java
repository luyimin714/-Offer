public class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }

    public void AddTotail(ListNode head, int value){
        ListNode pNew = new ListNode(1);
        pNew.val = value;
        pNew.next = null;

        if (head == null) {
            head = pNew;
        }
        else {
            ListNode p = head;
            while (p.next != null)
                p = p.next;
            p.next = pNew;
        }
    }

    public void RemoveNode(ListNode head, int value){
        if (head == null)
            return;

        ListNode pToBeDeleted = null;
        if (head.val == value){ //头节点
            pToBeDeleted = head;
            head = head.next;
        }
        else {
            ListNode p = head;
            while (p.next != null && p.next.val != value)
                p = p.next;
            if (p.next != null && p.next.val == value) {
                pToBeDeleted = p.next;
                p.next = p.next.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(head.val);
        head.AddTotail(head, 2);
        System.out.println(head.next.val);
        head.AddTotail(head, 3);
        System.out.println(head.next.next.val);
    }
}
