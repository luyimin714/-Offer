public class Question7_1 {
    /**
     * leetcode  106. 从中序与后序遍历序列构造二叉树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] in, int inStart, int inEnd,
                            int[] post, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;

        //后序遍历序列的最后一个数字为根节点
        TreeNode root = new TreeNode(post[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val)
                inIndex = i;
        }
        root.left = helper(in, inStart, inIndex-1, post, postStart, postStart+inIndex-inStart-1);
        root.right = helper(in, inIndex+1, inEnd, post, postStart+inIndex-inStart, postEnd-1);
        return root;
    }
}
