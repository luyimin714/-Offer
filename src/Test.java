public class Test {
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean res = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                res = tree1HasTree2(root1, root2);
            if (!res)
                res = tree1HasTree2(root1.left, root2);
            if (!res)
                res = tree1HasTree2(root1.right, root2);
        }

        return res;
    }

    private boolean tree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right);
    }

    public void permutation(String str) {
        if (str == null)
            return;
        permutation(str.toCharArray(), 0);
    }

    private void permutation(char[] str, int begin) {
        if (begin == str.length) {
            System.out.println(String.valueOf(str));
        } else {
            for (int i = begin; i < str.length; i++) {
                swap(str, i, begin);
                permutation(str, begin + 1);
                swap(str, i, begin);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Test print = new Test();
        print.permutation("abc");
    }
}
