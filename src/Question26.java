public class Question26 {
    public boolean HasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (Equal(root1.value, root2.value)) {
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

    private boolean DoesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (!Equal(root1.value, root2.value))
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
