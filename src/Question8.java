public class Question8 {
    public BinaryTreeNode getNext(BinaryTreeNode node){
        if (node == null)
            return null;
        BinaryTreeNode next = null;
        if (node.right != null){
            BinaryTreeNode right = node.right;
            while (right.left != null){
                right = right.left;
            }
            next = right;
        }
        else if (node.parent != null){
            BinaryTreeNode current = node;
            BinaryTreeNode parent = node.parent;
            while (parent != null && current == parent.right){
                current = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }
}
