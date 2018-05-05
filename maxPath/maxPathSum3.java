//maxPathSum3: subroot - leaf
public int maxPathSum3(TreeNode root){
	int[] max = new int[]{Integer.MIN_VALUE};
	helper(root,max);
	return max[0];
}
private int helper(TreeNode root, int[] max){
	if(root == null)
		return 0;
	//step1
	int left = helper(root.left, max);
	int right = helper(root.right, max);
	left = left > 0 ? left: 0;
	right = right > 0 ? right : 0;
	//step2
	//if leaf - leaf, then
	//max[0] = Math.max(root.key + left + right, max[0]);
	//if subroot - leaf
	max[0] = Math.max(max[0], root.key + Math.max(left, right));
	//step3
	return root.key + Math.max(left, right);
}
