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



	//leetocode check long type 		
			public boolean isValidBST(TreeNode root) {
			        return isBSTHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
			  }
			  private boolean isBSTHelper(TreeNode root, Long max, Long min){
			    //base case
			  	if(root == null)
			      return true;
			    //current level
			    if(root.val <= min || root.val >= max)
			      return false;
			    //recursive rule;
			    return isBSTHelper(root.left, (long)root.val, min)
			      && isBSTHelper(root.right, max, (long)root.val);
			  }
