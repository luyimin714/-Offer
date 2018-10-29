public class Question35 {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        RandomListNode next;

        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        iter = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copyIter = dummy;

        while (iter != null) {
            next = iter.next.next;

            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            iter.next = next;

            iter = next;
        }

        return dummy.next;
    }

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
