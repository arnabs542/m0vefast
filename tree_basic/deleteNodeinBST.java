//recurvie solution
public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
	if(root == null || p == null)
		return null;
	if(root.val <= p.val)
		return inorderSuccessor(root.right, p);
	else{
		TreeNode res = inorderSuccessor(root.left, p);
		if(res == null)
			return root;
		return res;
		//return (left != null)? left : root;
	}
}
//iteration solution
http://www.jiuzhang.com/solution/inorder-successor-in-binary-search-tree/

//recurvie solution
public TreeNode inorderPredecessor(TreeNode root, TreeNode p){
	if(root == null || p == null)
		return null;
	if(root.val >= p.val)
		return inorderPredecessor(root.left, p);
	else{
		TreeNode res = inorderPredecessor(root.right, p);
		if(res == null)
			return root;
		return res;
		//return (left != null)? left : root;
	}
}
//iteration solution
http://www.jiuzhang.com/solution/inorder-successor-in-binary-search-tree/

//solution1: iteration 
public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return root;
        }
        TreeNode tmp = root;
        TreeNode last = null;
        while (tmp != null) {
            last = tmp;
            if (tmp.val > node.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }
        return root;
    }
//solution2: recursion 
public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        int len = A.length-1;
        TreeNode root = null;  
        root = recursion(A, 1, len, root);
        A = null;
        return root;  
    }  
    public TreeNode recursion(int[] array, int lhs, int rhs, TreeNode root){  
        if(lhs <= rhs){  
            int mid = lhs + (rhs - lhs)/2;
            root = new TreeNode(array[mid]);  
            root.left = recursion(array, lhs, mid - 1, root.left);  
            root.right = recursion(array, mid + 1, rhs, root.right);  
        }  
        return root;  
    }  

