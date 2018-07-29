// Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
// 'lca' is lowest common ancestor of n1 and n2
public int getDistanace(TreeNode root, TreeNode node1, TreeNode node2) {

  if (root == null || node1 == null || node2 == null)
   return -1;
  TreeNode ancestor = LCA(root, node1, node2); // error handling, if no lca
  int depth1 = getDepth(root, ancestor);
  int depth2 = getDepth(root, node1);
  int depth3 = getDepth(root, node2);
  return depth2 + depth3 - 2 * depth1;

 }

 private TreeNode LCA(TreeNode curr, TreeNode node1, TreeNode node2) {
  if (curr == null)
   return null;
  if (curr == node1 || curr == node2)
   return curr;
  TreeNode left = LCA(curr.left, node1, node2);
  TreeNode right = LCA(curr.right, node1, node2);
  if(left != null && right != null)
   return curr;
  return left == null? right: left;
 }

 private int getDepth(TreeNode curr, TreeNode target) {
  if (curr == null)
   return -1;
  if (curr == target)
   return 0;
  int left = getDepth(curr.left, target);
  int right = getDepth(curr.right, target);
  if (left == -1 && right == -1)
   return -1;
  return left == -1? right + 1: left + 1;

 }
