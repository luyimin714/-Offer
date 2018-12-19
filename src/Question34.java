import java.util.ArrayList;
import java.util.List;

public class Question34 {
    /**
     *                      二叉树中和为某一值的路径
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返
     * 回值的list中，数组长度大的数组靠前)
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, new ArrayList<>(), 0, sum);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> path,  int cur, int sum) {
        if (root != null) {
            path.add(root.val);
            cur += root.val;
            boolean isLeaf = root.left == null && root.right == null;
            if (cur == sum && isLeaf) {
                // 如果直接add(list)，那么listAll的每一次add最终都指向同一个list对象，
                // 也就是说，虽然当前保存的是对的list对象，但之后这个list对象会被后续的
                // 递归修改，到最后的时候，得到的是空list，因此需要new一个list来保存当
                // 前对象的状态
                res.add(new ArrayList<>(path));
                //path.remove(path.size() - 1);
                //return;
            }

            helper(root.left, res, path, cur, sum);
            helper(root.right, res, path, cur, sum);

            path.remove(path.size() - 1);
        }
    }

    //leetcode
    private void helper2(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res, int cur) {
        if (root == null) return;

        path.add(root.val);

        boolean isLeaf = ((root.left == null) && (root.right == null));
        if (sum == root.val && isLeaf) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else {
            helper2(root.left, sum-root.val, path, res, cur);
            helper2(root.right, sum-root.val, path, res, cur);
        }
        path.remove(path.size() - 1);
    }
}
