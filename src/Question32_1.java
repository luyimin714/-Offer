import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question32_1 {
    /*
     *              二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即 逐层 地，从左到右访问所有节点）。
     */

    /*
     * 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
     * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
     * add()和remove()方法在失败的时候会抛出异常(不推荐)
     * Queue<String> queue = new LinkedList<String>();
     * 添加元素 queue.offer("a");
     * 返回第一个元素，并在队列中删除 queue.poll();
     * 返回第一个元素  queue.element();
     * 返回第一个元素  queue.peek();
     */
    //递归 LeetCode
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            res.add(list);
        }

        return res;
    }

    //递归
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    //利用二叉树的先序遍历
    private void helper(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) return;
        if (res.size() <= level) {
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }

        res.get(level).add(cur.val);

        helper(cur.left, res, level + 1);
        helper(cur.right, res, level + 1);
    }

    //剑指offer
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return res;

        queue.offer(root);
        int nextLevel = 0;
        int toBePrint = 1;

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {

            TreeNode node = queue.peek();

            list.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }

            queue.poll();
            toBePrint--;

            if (toBePrint == 0) {
                res.add(list);
                list = new ArrayList<>();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }

        return res;
    }
}
