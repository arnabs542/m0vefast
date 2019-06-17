public int minDepth(TreeNode root){
  if(root == null)
    return 0;
  //LinkedList<TreeNode> nodes = new LinedkList<>();
  Queue<TreeNode> nodes = new LinedkList<>();
  Queue<Integer> counts = new LinkedList<>();

  nodes.add(root);
  counts.add(1);
  //level order
  while(!nodes.isEmpty()){
    //TreeNode cur = nodes.remove();
    TreeNode cur = nodes.poll();
    int count = count.poll();

    if(cur.left == null && cur.right == null)
      return count;

    if(cur.left != null){
      nodes.offer(cur.left);
      counts.offer(count+1);
    }
    if(cur.right != null){
      node.offer(cur.right);
      count.offer(count+1);
    }
  }
  return 0;
}
