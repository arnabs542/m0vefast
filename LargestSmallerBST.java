public int largestSmaller(TreeNode root, int target){
	int res = Integer.MIN_VALUE;
	while(root != null){
		//case1: cur.value >= target, dont update res, go leftchild
		if(root.key >= target){
			root = root.left;
	  //case2: cur.value < target, update res, go right
		}else{
			res = root.key;
			root = root.right;
		}
	}
	return res;
}
