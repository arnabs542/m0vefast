//solution1: O(n)
public boolean isBalanced(TreeNode root){
	if(root == null)
		return true;
	int res = height(root);
	if(res == 0){
		return true;
	//else res = -1
	return false;
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
