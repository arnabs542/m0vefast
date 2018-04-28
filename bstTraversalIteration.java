
public List<Integer> inOrderTraversal(TreeNode root){
	Stack<TreeNode> stack = new Stack<TreeNode>();
	List<Integer> res = new ArrayList<>();
	TreeNode cur = root;
	while(cur != null ||!stack.empty()){
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
		cur = stack.pop();
		res.add(cur.value);
		cur = cur.right;
	}
	return res;
}
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
public List<Integer> postOrderTraversal(TreeNode root){
	Stack<TreeNode> stack = new Stack<TreeNode>();
	List<Integer> res = new ArrayList<>();
	TreeNode prev = null;  //previouly traversed node(left->right->root)
	TreeNode curr = root;
	if(root == null)
		return res;
	stack.push(root);
	while(!stack.isEmpty()){
		curr = stack.peek();
		//have traversed anything, // traverse down the tree
		if(prev == null || prev.left == curr || prev.right == curr){
			if(curr.left != null)
				stack.push(curr.left);
			else if(curr.right != null)
				stack.push(curr.right);
		// traverse up the tree from the left
		}else if(curr.left == prev){
			if(curr.right != null)
				stack.push(curr.right);
		// traverse up the tree from the right
		}else{ 
			res.add(curr.val); 
			stack.pop(); 
		}
		prev = curr;
	}
	return res;
}
}









