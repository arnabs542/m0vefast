//didnt pass!!!!!!!!!!!!
public TreeNode reconstruct(int[] pre){
  //in order index?
  int[] index = new int[]{0};  //pass by reference
  return helper(pre, index, Integer.MAX_VALUE);
}
private TreeNode helper(int[] pre, int[] index, int max){
  if(index[0] < 0 || pre[index[0]] >= max){
    return null;
  }
  TreeNode root = new TreeNode(pre[index[0]]);
  //order matter
  root.right = helper(pre, index, max);
  root.left = helper(pre, index, root.key);
  return root;
}
