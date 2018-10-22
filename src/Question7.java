public class Question7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1,
                      inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = 0; i < inorder.length; i++){
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
