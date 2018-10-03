// The diameter is defined as the longest distance from one leaf node to another leaf node.
//longest path of the given  2 leaf node(leaf node to left node)
public int diameter(TreeNode root){
  int[] totalNodes = new int[1];
  getDepth(root, totalNodes);
  return totalNodes[0];
}
//get height of a tree 
private int getDepth(TreeNode root, int[] totalNodes){
  if(root == null)
    return 0;
  int left = getDepth(root.left, totalNodes);
  int right = getDepth(root.right, totalNodes);
  totalNodes[0] = Math.max(left + right + 1);
  return Math.max(left, right) + 1;
}
