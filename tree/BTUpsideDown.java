//solution1: recursion
public TreeNode reverse(TreeNode root){
	if(root == null || root.left == null)
		return root;
	TreeNode newRoot = reverse(root.left);
	root.left.right = root.right;
	root.left.left = root;
	root.left = null;
	root.right = null;
	return newRoot;
}

//solution2: iterative
public TreeNode reverse(TreeNode root){
	TreeNode prev = null;
	TreeNode preRight = null;
	while(root != null){
		TreeNode next = root.right;
		TreeNode right = preRight;
		root.right = preRight;
		root.left = prev;
		prev = root;
		root = next;
	}
	return prev;
}
