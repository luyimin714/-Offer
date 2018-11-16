public class Question55 {
    /********************************************
     *          二叉树的深度
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）
     * 形成树的一条路径，最长路径的长度为树的深度。
     ********************************************/
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return left > right ? left + 1 : right + 1;
    }

    /*******************************************
     *              平衡二叉树
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     *******************************************/
    //需要重复遍历节点多次
    public boolean isBalancedNaive(TreeNode root) {
        if (root == null)
            return true;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int diff = Math.abs(left - right);
        if (diff > 1)
            return false;

        return isBalancedNaive(root.left) && isBalancedNaive(root.right);
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;

        int left = depth(root.left);
        if (left == -1)
            return -1;
        int right = depth(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        Question55 test = new Question55();
        System.out.println(test.isBalanced(root));
    }
}
