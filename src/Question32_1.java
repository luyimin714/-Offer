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
    public List<List<Integer>> levelOrder1(TreeNode root) {
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

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return res;

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

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                System.out.print(queue.poll().val + " ");
            }
            System.out.println();
        }
    }

    public static void print2(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrint = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            System.out.print(node.val + " ");
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
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(6);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        print(root);

        print2(root);
    }
}
