# preorder: Go down through the left, when right is not null, push right to stack.
def flattenSingleList(root):
    if root is None:
        return root
    stack = [root]
    while stack:
        node = stack.pop()
        if node.right:
            stack.append(node)
        if node.left:
            stack.append(node)

        node.left = None
        node.right = stack[-1] if stack else None
    return

    public List<Integer> preOrderTraversal(TreeNode root){
    	Stack<TreeNode> stack = new Stack<>();
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
