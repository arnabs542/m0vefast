public TreeNode reconstruct(int[] post){
  //only one element: index of the root
  int[] index = new int[]{post.length-1};
  return helper(post, index, Integer.MIN_VALUE);
}
private TreeNode helper(int[] post, int[] index, int min){
  //如果比root小的时候那其实是某个node的左孩子，反正不是现在这个
  if(index[0] < 0 || post[index[0]] <= min){
    return null;
  }
  //using the root value to determine the left and right
  //root is at the end of post[]
  //boundary of left/right subtree
  //root.key 小于 min的时候返回null，他的右孩子不能比root小
  TreeNode root = new TreeNode(post[index[0]--]);
  //order matter
  root.right = helper(post, index, root.key);
  root.left = helper(post, index, min);
  return root;
}
