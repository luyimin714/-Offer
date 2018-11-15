import java.util.Stack;

public class Question54 {
    /************************************************************
     *                  二叉搜索树的第k个结点
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
     * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
     ************************************************************/

    /*
     * LeetCode
     */
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode node) {
        if (node.left != null)
            helper(node.left);

        count--;

        if (count == 0) {
            number = node.val;
            return;
        }

        if (node.right != null)
            helper(node.right);
    }

    //迭代版本(基于二叉树的中序遍历)
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int res = -1;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            k--;
            if (k == 0) {
                res = cur.val;
                break;
            }

            cur = cur.right;
        }

        return res;
    }

    /*
     * 剑指Offer
     */
    private static int kk = 0;
    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k == 0)
            return null;

        kk = k;

        return kthNodeCore(root);
    }

    private TreeNode kthNodeCore(TreeNode root) {
        TreeNode target = null;

        if (root.left != null)
            target = kthNodeCore(root.left);

        if (target == null) {
            if (kk == 1)
                target = root;

            kk--;
        }

        if (target == null && root.right != null)
            target = kthNodeCore(root.right);

        return target;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        Question54 test = new Question54();
        System.out.println(test.kthNode(root, 3).val);
        System.out.println(test.kthSmallest(root, 3));
        System.out.println(test.kthSmallest2(root, 3));
    }
}
