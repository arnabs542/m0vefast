public List<Integer> borderView(TreeNode root) {
    // full circle
    List<Integer> res = new ArrayList<>();
    if(root == null)
        return res;
    res.add(root.value);
    //true as leftmost node, false as bottom/leafnode
    //a node can be left/right mode and bottom node as well, boolean print: is bottom node?
    getLeft(res, root.left, true);
    getRight(res, root.right, true);
    // helper(res, root.left, true, false);
    // helper(res, root.right, false, true);
    return res;
}
//When a node is a leftmost edge, then its left child must also be a leftmost edge
//in order
private void getLeft(List<Integer> res, TreeNode root, boolean print){
  if(root == null)
    return;
    // if node has no kids print.(for lower level)
  if(print || (root.right == null && root.left == null))
    res.add(root.value);
  getLeft(res, root.left, print);  // the left kid of  a left child should be printed
  getLeft(res, root.right, false);   //bottom (cover the overlap node)
}
//post order
private void getRight(List<Integer> res, TreeNode root, boolean print){
  if(root == null)
    return;
  getRight(res, root.left, print);   // right kid of a right child will be printed.
  getRight(res, root.right, false);  //right, fasle: not bottom
    // if node has no kids print.(for lower level)
  if(print || (root.right == null && root.left == null))
    res.add(root.value);
}
//https://piazza.com/class/j0eqhhdregb3i?cid=2897: "first get all the border nodes at left side(from root and always go to the left subtree, from top to bottom)"
// https://gist.github.com/KodeSeeker/9825360
// Approach :
// Depth first search: Pattern : Root, then left and then right in backwards fashion.
// Key point:
// If a node is a left outer node then its left child is also a left outer node.
// If a node is a right outer node then its right child is also a right outer node.
// Left nodes: Pre order traversal printing only left nodes.
// Right nodes: Post order traversal(to reverse order of nodes) And print only the right nodes.

binary tree:
bfs: level order
dfs: inorder, preorder, postorder
private void helper(List<Integer> res, TreeNode root, boolean leftprint, boolean rightprint){
  if(root == null)
    return;
  if(root.left != null && root.right != null){
    res.add(root.value);
    return;
  }
  if(leftprint)
    res.add(root.value);
  helper(res, root.left, left && node.left != null, right && root.right == null, res);
  helper(res, root.right, left && node.right == null, right && root.right != null, res);
  if(rightprint)
    res.add(root.value);
}
