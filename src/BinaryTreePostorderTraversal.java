import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    /*
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
            if (cur.left != null) helper(cur.left, list);
            if (cur.right != null) helper(cur.right, list);

            //do something
            list.add(cur.val);
        }
    }
}
