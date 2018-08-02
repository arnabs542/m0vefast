//dfs
public TreeNode reconstruct(int[] in) {
  if(arr.length == 0)
    return null;
  return helper(arr, 0, arr.length-1);
}
private TreeNode helper(int[] arr, int left, int right){
  if(left > right)
    return null;
  int mid = (left + right)/2;
  TreeNode root= new TreeNode(arr[mid]);
  root.left = helper(arr, left, mid-1);
  root.right = helper(arr, mid+1, right);
  return root;
}
