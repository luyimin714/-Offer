public class Question8 {
    /***************************************************************
                        二叉树的下一个结点
     给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     **************************************************************/
    public TreeNode getNext(TreeNode pNode) {
        if (pNode == null)
            return null;
        TreeNode next = null;
        if (pNode.right != null) {
            TreeNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
        }
        else if (pNode.parent != null) {
            TreeNode current = pNode;
            TreeNode parent = pNode.parent;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }
}
