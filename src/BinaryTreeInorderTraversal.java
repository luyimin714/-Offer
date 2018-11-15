import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    /*
     * 二叉树的中序遍历
     */

    /*
     * 递归
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        helper(root, inorder);
        return inorder;
    }

    private void helper(TreeNode root, List<Integer> inorder) {
        if (root != null) {
            if (root.left != null)
                helper(root.left, inorder);

            inorder.add(root.val);

            if (root.right != null)
                helper(root.right, inorder);
        }
    }

    /*
     * 迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            inorder.add(cur.val);
            cur = cur.right;
        }

        return inorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
        System.out.println(test.inorderTraversal1(root).toString());
        System.out.println(test.inorderTraversal2(root).toString());
    }
}
