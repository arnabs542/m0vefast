//preorder: Go down through the left, when right is not null, push right to stack.
public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null || !stack.empty()){
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }
            p = p.right;
        }
    }

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
