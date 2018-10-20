public class Question18_1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
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

    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next == cur){ //不是重复节点
                pre = pre.next;
            }
            else{
                pre.next = cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
    }
}
