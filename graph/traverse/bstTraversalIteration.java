public List<Integer> inOrderTraversal(TreeNode root){
	Stack<TreeNode> stack = new Stack<TreeNode>();   //record for direction
	List<Integer> res = new ArrayList<>();
	TreeNode cur = root;
	while(cur != null ||!stack.empty()){
		//go till the very left
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
//kth smallest node in bst
public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
		//go to the deepest left
    while(p!=null){
        stack.push(p);
        p=p.left;
    }
		//start poping k times
    int i = 0;
    while(!stack.isEmpty()){
        TreeNode cur = stack.pop();
        i++;

        if(i == k)
            return cur.val;
 				else{
					TreeNode r = cur.right;
	        while(cur!=null){
	            stack.push(r);
	            r=r.left;
	        }
				}
    }
    return -1;
}
//kth largest node in bst
https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/


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

public List<Integer> postorderTraversal(TreeNode root) {
	Stack<TreeNode> stack=new Stack<TreeNode>();
	List<Integer> res = new ArrayList<>();
		if(root==null){
			return res;
		}
		stack.push(root);
		while(!stack.isEmpty()){
				TreeNode node=stack.pop();
				//Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices)
				res.add(0, node.key); //插在第一个位置，使得满足“左右根”
				if(node.left!=null){
						stack.push(node.left);
				}
				if(node.right!=null){
						stack.push(node.right);
				}
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
