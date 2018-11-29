import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question32 {
    /*
     * 从上往下打印二叉树
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
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

        printLevelOrder(root);
    }
}
