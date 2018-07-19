https://blog.csdn.net/whuwangyi/article/details/43186045
//go to the deep left
//root.left = parent.right
//root.right = parent
public TreeNode reverseTree(TreeNode root){
  if(root == null || root.left == null)
    return root;
  TreeNode newRoot = reverseTree(root.left);
  root.left.left = root.right;
  root.left.right = root;
  root.left = null;
  root.right = null;
  return newRoot;
}

//iterative
public TreeNode reverseTree(TreeNode root){
    TreeNod prev = null;
    TreeNode preRight = null;
    while(root != null){
        TreeNode next = root.left;
        TreeNode right = root.right;
        root.right = preRight;
        root.left = prev;
        preRight = right;
        prev = root;
        root = next;
    }
    return prev;
}
