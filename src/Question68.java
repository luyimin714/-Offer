public class Question68 {
    /*
     * 若p和q要么分别位于左右子树中，那么对左右子结点调用递归函数，
     * 会分别返回p和q结点的位置，而当前结点正好就是p和q的最小共同
     * 父结点，直接返回当前结点即可，这就是题目中的例子1的情况。
     *
     * 若p和q同时位于左子树，这里有两种情况，一种情况是left会返回
     * p和q中较高的那个位置，而right会返回空，所以我们最终返回非空
     * 的left即可。还有一种情况是会返回p和q的最小父结点，就是说当
     * 前结点的左子树中的某个结点才是p和q的最小父结点，会被返回。
     *
     * 若p和q同时位于右子树，同样这里有两种情况，一种情况是right会
     * 返回p和q中较高的那个位置，而left会返回空，所以我们最终返回非
     * 空的right即可，还有一种情况是会返回p和q的最小父结点，就是说
     * 当前结点的右子树中的某个结点才是p和q的最小父结点，会被返回。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
