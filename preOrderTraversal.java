public List<Integer> preOrderTraversal(TreeNode root){
	Stack<TreeNode> stack = new Stack<TreeNode>();
	List<Integer> res = new ArrayList<>();
	if(root == null)
		return res;
	stack.push(root);
	while(!stack.empty()){
		TreeNode node = stack.pop();
		res.add(node.val);
		if(node.right != null)
			stack.push(node.right);
		if(node.left != null)
			stack.push(node.left);
	}
	return res;
}
public List<Integer> preOrderTraversal(TreeNode root){
	List<Integer> res = new ArrayList<>();
	traverse(root, res);
	return res;
}
private void traverse(TreeNode root){
	if(root == null)
		return;
	res.add(root.val);
	traverse(root.left, res);
	traverse(root.right, res);
}
public List<Integer> preOrderTraversal(TreeNode root){
	List<Integer> res = new ArrayList<>();
	//base
	if(root == null)
		return res;
	//divide
	List<Integer> left = preOrderTraversal(root.left);
	List<Integer> right = preOrderTraversal(root.right);
	//conquer
	res.add(root.val);
	res.addAll(left);
	res.addAll(right);
	return res;
}