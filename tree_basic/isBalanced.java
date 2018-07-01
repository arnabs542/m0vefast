//solution1: O(n)
public boolean isBalanced(TreeNode root){
	if(root == null)
		return true;
	//use -1 to denote the Tree is not balanced
	//>= 0 means tree is balanced and is the hgiht of the tree
	return height(root) != -1;
}
private int height(TreeNode root){
	if(root == null){
		return 0;
	}
	//step1:
	int leftHeight = height(root.left);
	int rightHeight = height(root.right);
	//step2:
	if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
		return -1;
	}
	//step3:
	return Math.max(leftHeight, rightHeight) + 1;
}


//solution2: O(nlgn)
public boolean isBalanced(TreeNode root){
	//base case
	if(root == null)
		return true;
	//divide
	int leftHeight = getHeight(root.left);
	int rightHeight = getHeight(root.right);
	//conquer
	if(Math.abs(leftHeight - rightHeight) > 1)
		return false;
	return isBalanced(root.left) && isBalanced(root.right);
}
private int getHeight(TreeNode root){
	if(root == null)
		return 0;
	return 1 + Math.max(getHeight(root.right), getHeight(root.left));
}


public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
