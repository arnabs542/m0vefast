public boolean isBST(TreeNode root){
	if(root == null)
		return true;
	return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
private boolean isBSTHelper(TreeNode root, int max, int min){
    //base case
  	if(root == null)
      return true;
    //current level
    if(root.key <= min || root.key >= max)
      return false;
    //recursive rule;
    return isBSTHelper(root.left, root.key, min)
      && isBSTHelper(root.right, max, root.key);
