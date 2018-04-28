//maxPathSum1: leaf - leaf
//lai solution
public int maxPathSum1(TreeNode root){
	//wrap a global var into an arr, so we can change the value during recursion
	int[] res = new int[]{Integer.MIN_VALUE};
	helper(root, res);
	return res[0];
}
private int helper(TreeNode root, int[] res){
	if(root == null)
		return 0;
	//step1:
	int left = helper(root.left, res);
	int right = helper(root.right, res);
	//step2:
	//only when cur node is not leaf node, we might need to update res
	if(root.left != null && root.right != null){
		res[0] = Math.max(res[0], left + right + root.value);
		//return Math.max(left, right) + root.value;
	//step3:
	}else if(root.left == null){
		return right + root.value;
	}else if(root.right == null){
		return left + root.value;
	}
	return Math.max(left, right) + root.value;
}
