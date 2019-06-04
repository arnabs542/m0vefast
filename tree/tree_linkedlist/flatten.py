//preorder: Go down through the left, when right is not null, push right to stack.
public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();  //subtree to be explored
        TreeNode cur = root;
        //not reaching deep left of cur substree
        //for all other subtree
        while(cur != null || !stack.empty()){
            //save right
            if(cur.right != null){
                stack.push(cur.right);
            }
            //change left 1) if reach end of curr subtree
            if(cur.left != null){
                cur.right = cur.left;
                cur.left = null;
            //reach end, 2) try other subtree
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                cur.right=temp;
            }
            cur = cur.right;  //move to next processing subtree node
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
