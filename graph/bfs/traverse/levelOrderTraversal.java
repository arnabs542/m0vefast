public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	if(root == null)
		return res;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while(!queue.isEmpty()){
		ArrayList<Integer> level = new ArrayList<>();
		int size = queue.size();
		for(int i = 0; i < size; i++){
			TreeNode cur = queue.poll();
			level.add(cur.val);
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
		}
		res.add(level);
	}
	return res;
}
//from bottom to up
https://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-ii-java/
public List<List<Integer>> levelOrderII(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	if(root == null)
		return res;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while(!queue.isEmpty()){
		ArrayList<Integer> level = new ArrayList<>();
		int size = queue.size();
		for(int i = 0; i < size; i++){
			TreeNode cur = queue.poll();
			level.add(cur.val);
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
		}
		res.add(level);
	}
	return Collections.reverse(res);
}
