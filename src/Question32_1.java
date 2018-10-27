import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question32_1 {
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
