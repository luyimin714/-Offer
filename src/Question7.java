public class Question7 {
    /*******************************************************************
                        重建二叉树
    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
    则重建二叉树并返回。
     ******************************************************************/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1,
                      inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val)
                inIndex = i;
        }
        root.left = helper(preorder, preStart+1, preStart+1+inIndex-inStart,
                           inorder,          inStart,     inIndex-1);
        root.right = helper(preorder, preStart+1+inIndex-inStart, preEnd,
                            inorder,   inIndex+1,                  inEnd);
        return root;
    }
}
