
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



//solution: traverse
public ArrayList<Integer> inorderTraversal(TreeNode root){
	ArrayList<Integer> res = new ArrayList<>();
	traverse(root, res);
	return res;
}
private void traverse(TreeNode root, ArrayList<Integer> res){
	if(root == null)
		return res;
	traverse(root.left, res);
	res.add(root.val);
	traverse(root.right, res);
}

//solution1: divide and conquer
public ArrayList<Integer> inorderTraversal(TreeNode root){
	ArrayList<Integer> res = new ArrayList<>();
	if(root == null)
		return;
	//divide
	//notice if funciton return type is List<IntegeR>, then below should be:
	//List<Integer> left = inorderTraversal(root.left);
	ArrayList<Integer> left = inorderTraversal(root.left);
	ArrayList<Integer> right = inorderTraversal(root.right);
	//conquer
	res.addAll(left);
	res.add(root.val);
	res.addAll(right);
	return res;
}
//solution2: iteration
public ArrayList<Integer> inorderTraversal(TreeNode root){
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> res = new ArrayList<>();
	TreeNode cur = root;
	while(cur != null || !stack.isEmpty()){
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
		cur = stack.pop();
		res.add(cur.val);
		cur = cur.right;
	}
	return res;
}









