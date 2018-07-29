public TreeNode reconstructCompleteLevelOrder(int[] level){
   return helper(level, new TreeNode(level[0]), 0);
}
private TreeNode helper(int[] level, TreeNode root, int index){
  if(index < level.length){
    TreeNode temp = new TreeNode(level[i]);
    root = temp;
    //for a complete binary tree, left child is 2*root+1, right child is 2*root+2
    root.left = helper(level, root.left, 2*index+1);
    root.right = helper(level, root.right, 2*index+2)；
  }
  return root;
}
