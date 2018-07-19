public List<Integer> getRange(TreeNode root, int min, int max) {
	List<Integer> res = new ArrayList<>();
	helper(root, min, max, res);
	return res;
}
private void helper(TreeNode root, int min, int max, List<Integer> res){
	if(root == null)
		return;
	//1. determine if left subtree should be traversed, only when root.key > min
	if(root.key > min)
		helper(root.left, min, max, res);
	//2. determind if root should be traversed
	if(root.key >= min && root.key <= max)
		res.add(root.key);
	//3. deteming if right subtree should be traversed, only when root.key < max
	if(root.key < max)
		helper(root.right, min, max, res);
}