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
