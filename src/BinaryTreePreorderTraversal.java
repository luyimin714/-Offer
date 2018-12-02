import java.util.ArrayList;
import java.util.List;

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
}
