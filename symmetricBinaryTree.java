public boolean isSymmetric(TreeNode root) {
	if(root == null)
		return true;
	return helper(root.left, root.right);
}
private boolean helper(TreeNode one, TreeNode two){
	if(one == null && two == null)
		return true;
	else if(one == null || two == null)
		return false;
	else if(one.key != two.key)
		return false;
	return helper(one.left, two.right) 
			&& helper(one.right, two.left);
}