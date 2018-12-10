import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    /**
     * 二叉树的后序遍历
     */

    //递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode cur, List<Integer> list) {
        if (cur != null) {
            helper(cur.left, list);
            helper(cur.right, list);

            //do something
            list.add(cur.val);
        }
    }

    //迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                list.addFirst(cur.val);
                cur = cur.right;
            }

            cur = stack.pop();
            cur = cur.left;
        }

        return list;
    }
}
