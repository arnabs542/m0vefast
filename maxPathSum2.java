//maxPathSum1: any - any

//from any node to any node
public int maxPathSum2(TreeNode root){
	//max store global maximun path sum, updated during recursion
	int[] max = new int[]{Integer.MIN_VALUE};
	helper(root, max);
	return max[0];
}
//return the max path sum of a single path
private int helper(TreeNode root, int[] max){
	if(root == null)
		return 0;
	//step1:
	int left = helper(root.left, max);
	int right = helper(root.right, max);
	left = left < 0 ? 0 : left;
	right = right < 0 ? 0 : right;
	//step2:
	max[0] = Math.max(root.key + left + right, max[0]);
	//step3:
	return root.key + Math.max(left, right);
}
