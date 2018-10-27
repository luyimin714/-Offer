import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question32_2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null)
            return;
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

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();

        int current = 0;
        int next = 1;

        stacks[current].push(root);

        List<Integer> list = new ArrayList<>();

        while ((!stacks[0].empty()) || (!stacks[1].empty())) {
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

    public static void Print(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();

        int current = 0;
        int next = 1;

        stacks[current].push(root);

        //System.out.println(stacks[current].peek().val);

        while ((!stacks[0].empty()) || (!stacks[1].empty())) {
            TreeNode node = stacks[current].peek();
            stacks[current].pop();

            System.out.print(node.val + " ");

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
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Print(root);
    }
}
