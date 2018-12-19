public class Question36 {
    /**
     *              二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */

    //正确
    private TreeNode pre = null;
    public TreeNode Convert(TreeNode root) {
        helper(root);
        TreeNode head = pre;
        while (head != null && head.left != null)
            head = head.left;
        return head;
    }
    //利用二叉树中序遍历
    private void helper(TreeNode cur) {
        if (cur != null) {
            helper(cur.left);

            //do something
            cur.left = pre;
            if (pre != null)
                pre.right = cur;
            pre = cur;

            helper(cur.right);
        }
    }

    //错误
    public TreeNode Convert2(TreeNode root) {
        TreeNode pre = null;
        helper2(root, pre);
        TreeNode head = pre;
        while (head != null && head.left != null)
            head = head.left;
        return head;
    }

    private void helper2(TreeNode cur, TreeNode pre) {
        if (cur != null) {
            if (cur.left != null) {
                helper2(cur.left, pre);
            }
            //do something
            cur.left = pre;
            if (pre != null)
                pre.right = cur;
            pre = cur;

            if (cur.right != null) {
                helper2(cur.right, pre);
            }
        }
    }
}
