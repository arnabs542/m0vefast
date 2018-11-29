public boolean isCompleted(TreeNode root){
	if(root == null)
		return true;
	Queue<TreeNode> queue = new LinkedList<>();
	//if flat is true, there should not be any children
	queue.offer(root);
	boolean flag = false;

	while(!queue.isEmpty(){
		TreeNode cur = queue.poll();
		//logic for left child
		//first time: if no left child => there should not be any children from now on,
		if(cur.left == null)
			flag = true;
		//have left child, but there shouldnt be => wrong;
		else if(flag)
			return false;
		//have left child, and full slot since begining
		else
			queue.offer(cur.left);

		//same logic for right child
		if(cur.right == null)
			flag = true;
		else if(flag)
			return false;
		else
			queue.offer(cur.right);
	}
	return true;
}

//more clear
public boolean isCompleted(TreeNode root) {
    // Write your solution here.
    if(root == null)
      return true;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean flag = false;

    while(!queue.isEmpty()){
    	TreeNode cur = queue.poll();

      if(cur.left == null)
        flag = true;
      if(cur.left != null && flag == true)
        return false;
      if(cur.left != null && flag == false)
        queue.offer(cur.left);

      if(cur.right == null)
        flag = true;
      if(cur.right != null && flag == true)
        return false;
      if(cur.right != null && flag == false)
        queue.offer(cur.right);
    }
    return true;
  }


//recursion:
//if a tree is a complete tree lol
private boolean isComplete(TreeNode root, int index, int amount_nodes){
  if(root == null)
    return true;
    // If index assigned to current node is more than number of nodes in tree, then tree is not complete
  if(index >= amount_nodes)
    return false;
  return isComplete(root.left, 2*index+1, amount_nodes) &&
          isComplete(root.right, 2*index+2, amount_nodes);
}
//count nodes o
public int countNodesCompleteTree(TreeNode root) {
    // Write your solution here
		int hleft = getLeftHeight(root.left);
		int hright = getRightHeight(root.right);
		if(hleft == hright)
			return pow(2, hleft-1)-1;  //2^h
		return countNodesCompleteTree(root.left) + countNodesCompleteTree(root.right);
}
private int getLeftHeight(TreeNode root){
	if(root == null)
		return 0;
	return 1 + getLeftHeight(root.left);
}
private int getRightHeight(TreeNode root){
	if(root == null)
		return 0;
	return 1 + getRightHeight(root.right);
}


http://www.cnblogs.com/grandyang/p/4567827.html




//google
//count total node of a complete Tree
iteration travrsal + a counter
//Time complexity is O(h^2) - O(log(n)^2)
public int totalCompleteTree(TreeNode root){
	int total_height = getHeight(root);
	int right_height = getHeight(root.right);
	if(right_height + 1 == total_height)  //full tree
		return (1 << total_height) + totalCompleteTree(root.right);
	return (1 << (total_height - 1)) + totalCompleteTree(root.left);
}
private int getHeight(TreeNode root){
	if(root == null)
		return -1;
	return 1 + getHeight(root.left);
}
