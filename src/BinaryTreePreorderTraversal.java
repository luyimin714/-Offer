import java.util.*;

public class BinaryTreePreorderTraversal {
    /*
     * 二叉树的前序遍历
     */

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode cur, List<Integer> list) {
        if (cur != null) {
            //do something
            list.add(cur.val);

            if (cur.left != null) helper(cur.left, list);
            if (cur.right != null) helper(cur.right, list);
        }
    }

    //迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return list;
    }
}
