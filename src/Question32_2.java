import java.util.*;

public class Question32_2 {
    /**
     *     按之字形顺序打印二叉树 / zigzag / 二叉树的锯齿形层次遍历
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    //解法1:递归 LeetCode 利用二叉树的先序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) return;
        if (res.size() <= level) {
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }
        if (level % 2 == 0) {
            res.get(level).add(cur.val);
        } else {
            res.get(level).add(0, cur.val);
        }

        helper(cur.left, res, level + 1);
        helper(cur.right, res, level + 1);
    }

    //解法2:迭代 在二叉树的层次遍历基础上修改
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();

                if (level % 2 != 0)
                    list.add(temp.val);
                else
                    list.add(0, temp.val);

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res.add(list);
            level++;
        }
        return res;
    }

    //解法3:剑指offer
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();

        int current = 0;
        int next = 1;

        stacks[current].push(root);

        List<Integer> list = new ArrayList<>();

        while (!stacks[0].empty() || !stacks[1].empty()) {
            TreeNode node = stacks[current].peek();
            stacks[current].pop();

            list.add(node.val);

            if (current == 0) {
                if (node.left != null)
                    stacks[next].push(node.left);
                if (node.right != null)
                    stacks[next].push(node.right);
            } else {
                if (node.right != null)
                    stacks[next].push(node.right);
                if (node.left != null)
                    stacks[next].push(node.left);
            }

            if (stacks[current].empty()) {
                res.add(list);
                list = new ArrayList<>();
                current = 1 - current;
                next = 1 - next;
            }

        }
        return res;
    }
}
