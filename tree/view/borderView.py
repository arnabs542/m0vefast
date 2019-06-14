//another solution:
public List<Integer> borderView(TreeNode root) {
    // full circle
    List<Integer> res = new ArrayList<>();
    if(root == null)
        return res;
    res.add(root.value);
    printLeft(root.left, res);  //preorder
    printLeaves(root.left, res);  //left to right, inorder
    printLeaves(root.right, res);  //left to right, inorder
    printRight(root.right, res);  //post order
    return res;
}
private void printLeft(TreeNode root, List<Integer> res){
  if(root == null)
    return;
  // to ensure top down order, print the node before calling itself for left subtree
  if(root.left != null){
    res.add(root.key);
    printLeft(root.left, res);
  }else if(root.right != null){
    res.add(root.key);
    printLeft(root.right, res);
  }
  //do nothing if it is a leaf node
}
private void printRight(TreeNode root, List<Integer> res){
  if(root == null)
    return;
  if(root.right != null){
    //to ensure bottom up order, first call for right subtree, then print this node
    printRight(root.right, res);
    res.add(root.key);
  }else if(root.left != null){
    printRight(root.left, res);
    res.add(root.key);
  }
  //do nothing if it is a leaf node
}
private void printLeaves(TreeNode root, List<Integer> res){
  if(root == null)
    return;
  //in order from left to right
  printLeaves(root.left, res);
  if(root.left == null && root.right == null)
    res.add(root.key);
  printLeves(root.right, res);
}
public List<Integer> borderView(TreeNode root) {
    // full circle
    List<Integer> res = new ArrayList<>();
    if(root == null)
        return res;
    res.add(root.value);
    //true as leftmost node, false as bottom/leafnode
    //a node can be left/right mode and bottom node as well, boolean print: is bottom node
    getLeft(res, root.left, true);
    getRight(res, root.right, true);
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
