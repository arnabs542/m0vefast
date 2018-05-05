public boolean isBST(TreeNode root){
	if(root == null)
		return true;
	return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
private boolean helper(TreeNode root, int low, int high){
	if(root.key < low || root.val > high)
		return false;
	if(root.left != null && !helper(root.left, low, root.val-1))
		return false;
	if(root.right != null && !helper(root.right, root.val+1, high))
		return false;
	return ture;
}