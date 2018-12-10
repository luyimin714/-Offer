public class Question8 {
    /**
     *                   二叉树的下一个结点
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    //
    public TreeNode getNext(TreeNode node) {
        if (node == null) return null;

        if (node.right != null) { //如果有右子树，则找右子树的最左节点
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        }
        while (node.parent != null ) { //没右子树，则找第一个当前节点是父节点左孩子的节点
            if (node.parent.left == node) return node.parent;
            node = node.parent;
        }
        return null; //退到了根节点仍没找到，则返回null
    }

    //剑指offer
    public TreeNode getNext2(TreeNode pNode) {
        if (pNode == null) return null;

        TreeNode next = null;
        if (pNode.right != null) { //如果有右子树，则找右子树的最左节点
            TreeNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
        } else if (pNode.parent != null) {
            TreeNode cur = pNode;
            TreeNode parent = pNode.parent;
            while (parent != null && cur == parent.right) { //没右子树，则找第一个当前节点是父节点左孩子的节点
                cur = parent;
                parent = parent.parent;
            }
            next = parent; //没右子树，该节点是其父节点左孩子的节点
        }
        return next;
    }
}
