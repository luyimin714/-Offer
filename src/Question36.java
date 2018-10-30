public class Question36 {
    public TreeNode Convert(TreeNode root) {
        TreeNode lastNodeInList = null;
        ConvertNode(root, lastNodeInList);

        TreeNode head = lastNodeInList;
        while (head != null && head.left != null)
            head = head.left;

        return head;
    }

    private void ConvertNode(TreeNode cur, TreeNode lastNodeInList) {
        if (cur == null)
            return;

        if (cur.left != null)
            ConvertNode(cur.left, lastNodeInList);

        cur.left = lastNodeInList;
        if (lastNodeInList != null)
            lastNodeInList.right = cur;

        lastNodeInList = cur;
        if (cur.right != null)
            ConvertNode(cur.right, lastNodeInList);
    }

    private void ConvertNode2(TreeNode node, TreeNode lastNodeInList) {
        if (node == null)
            return;

        TreeNode cur = node;

        if (cur.left != null)
            ConvertNode(cur.left, lastNodeInList);

        cur.left = lastNodeInList;
        if (lastNodeInList != null)
            lastNodeInList.right = cur;

        lastNodeInList = cur;

        if (cur.right != null)
            ConvertNode(cur.right, lastNodeInList);
    }
}
