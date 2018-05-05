public TreeNode reconstruct(int[] in, int[] post){
  int[] index = new int[]{post.length-1};
  return helper(post, index, Integer.MIN_VALUE);
}
private TreeNode helper(int[] post, int[] index, int min){
  if(index[0] < 0 || post[index[0]] <= min){
    return null;
  }
  //using the root value to determine the left and right
  //boundary of left/right subtree
  TreeNode root = new TreeNode(post[index[0]--]);
  root.right = helper(post, index, root.key);
  root.left = helper(post, index, min);
  return root;
}
