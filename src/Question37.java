import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(List<String> nodes) {
        String s = nodes.remove(0);
        if (s.equals("null"))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Question37 build = new Question37();
        String data = build.serialize(root);
        System.out.println(data);

        String[] s = data.split(",");

        TreeNode new_root = build.deserialize(data);
        System.out.println(new_root.val);
        System.out.println(new_root.left.val + " " + new_root.right.val);
        System.out.println(new_root.left.left.val + " " +
                new_root.right.left.val + " " + new_root.right.right.val);
    }
}
