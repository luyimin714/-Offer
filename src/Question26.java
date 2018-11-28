public class Question26 {
    /*
     *              树的子结构
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (Equal(root1.val, root2.val)) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (!Equal(root1.val, root2.val))
            return false;

        return DoesTree1HaveTree2(root1.left, root2.left) &&
                DoesTree1HaveTree2(root1.right, root2.right);
    }

    private boolean Equal(int num1, int num2) {
        return num1 == num2;
    }

    private boolean Equal(double num1, double num2) {
        return  ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001));
    }
}
