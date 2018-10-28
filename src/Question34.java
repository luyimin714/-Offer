import java.util.ArrayList;
import java.util.List;

public class Question34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        helper(root, sum, new ArrayList<>(), res, 0);

        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res, int cur) {
        cur += root.val;
        path.add(root.val);

        boolean isLeaf = ((root.left == null) && (root.right == null));
        if (cur == sum && isLeaf) {
            res.add(new ArrayList<>(path));
        }

        if (root.left != null)
            helper(root.left, sum, path, res, cur);
        if (root.right != null)
            helper(root.right, sum, path, res, cur);

        path.remove(path.size() - 1);
    }

    private void helper2(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res, int cur) {
        if (root == null)
            return;

        path.add(root.val);

        boolean isLeaf = ((root.left == null) && (root.right == null));
        if (sum == root.val && isLeaf) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else {
            helper(root.left, sum-root.val, path, res, cur);
            helper(root.right, sum-root.val, path, res, cur);
        }
        path.remove(path.size() - 1);
    }
}
