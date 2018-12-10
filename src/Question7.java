public class Question7 {
    /**
     *                   重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回。
     */
    public TreeNode buildTree(int[] pre, int[] in) {
        return helper(pre, 0, pre.length - 1,
                in, 0, in.length-1);
    }

    private TreeNode helper2(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;

        //前序遍历序列的第一个数字为根节点，然后扫描中序序列找到根节点的位置
        //从而确定左右子树的大小
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val)
                inIndex = i;
        }
        root.left = helper2(preorder,preStart+1,preStart+1+inIndex-inStart,
                           inorder,          inStart,     inIndex-1);
        root.right = helper2(preorder, preStart+1+inIndex-inStart, preEnd,
                            inorder,   inIndex+1,                  inEnd);
        return root;
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd,
                            int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val)
                inIndex = i;
        }
        root.left = helper(pre, preStart+1, preStart+inIndex-inStart,
                in, inStart, inIndex-1);
        root.right = helper(pre, preStart+inIndex-inStart+1, preEnd,
                in, inIndex+1, inEnd);
        return root;
    }
}
