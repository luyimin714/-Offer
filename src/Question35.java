public class Question35 {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next;
        //1.根据原始链表的每个节点N创建对应的N'，并将N'连接在N的后面
        while (cur != null) {
            next = cur.next;

            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;

            cur = next;
        }
        //2.设置复制出来的节点的random指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.把这个长链表拆成两个链表
        //奇数位置：原始链表  偶数位置：复制出来的链表
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyNext;
        RandomListNode copyCur = dummy;

        while (cur != null) {
            next = cur.next.next;
            copyNext = cur.next;

            copyCur.next = copyNext;
            copyCur = copyNext;

            cur.next = next;
            cur = next;
        }

        return dummy.next;
    }

    //剑指Offer
    public RandomListNode copyRandomList2(RandomListNode head) {
        CloneNodes(head);
        ConnectRandomNode(head);
        return ReconnectNodes(head);
    }

    private void CloneNodes(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode clone = new RandomListNode(node.label);
            clone.next = node.next;
            clone.random = null;

            node.next = clone;

            node = clone.next;
        }
    }

    private void ConnectRandomNode(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode clone = node.next;
            if (node.random != null) {
                clone.random = node.random.next;
            }

            node = clone.next;
        }
    }

    private RandomListNode ReconnectNodes(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;

        if (node != null) {
            cloneNode = node.next;
            cloneHead = cloneNode;
            node.next = cloneNode.next;
            node = node.next;
        }

        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }
}
