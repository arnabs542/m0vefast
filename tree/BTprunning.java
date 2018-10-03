//Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
public TreeNode pruneTree(TreeNode root) {
  if(root == null)
    return null;
  TreeNode left = pruneTree(root.left);
  TreeNode right = pruneTree(root.right);
  if((left != null && left.key == 0 && right != null && right.key == 0){
    root = null;
  return root;
}
