import java.util.*;

public class Question37 {
    /**
     *              二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
     * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可
     * 以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * 请设计一个算法来实现二叉树的序列化与反序列化。
     * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个
     * 二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     */

    //序列化 利用二叉树的前序遍历
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

    //反序列化 利用二叉树的前序遍历
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(List<String> nodes) {
        String s = nodes.remove(0);
        if (s.equals("null"))  //不能用 s == "null"
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
