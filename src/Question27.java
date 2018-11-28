public class Question27 {
    /*
     *  二叉树的镜像
     *  操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public void invertTree(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null)
            invertTree(root.left);

        if (root.right != null)
            invertTree(root.right);
    }

    //LeetCode
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree2(right);
        root.right = invertTree2(left);

        return root;
    }
}
