//determine is a tree is minheap
// It should be a complete tree (i.e. all levels except last should be full).
// Every node’s value should be smaller than or equal to its child node (considering min-heap).
public boolean isMinHeap(TreeNode root){
  if(root == null)
    return true;
  int amount_nodes = countNodes(root);
  if(isComplete(root, 0, amount_nodes) && isHeap(root))
    return true;
  return false;
}
//if a tree is a complete tree lol
private boolean isComplete(TreeNode root, int index, int amount_nodes){
  if(root == null)
    return true;
    // If index assigned to current node is more than number of nodes in tree, then tree is not complete
  if(index >= amount_nodes)
    return false;
  return isComplete(root.left, 2*index+1, amount_nodes) &&
          isComplete(root.right, 2*index+2, amount_nodes);
}
//check heap property of a tree
// Every Node can have 2 children, 0 child (last level nodes) or 1 child (there can be at most one such node).
// If Node has No child then it’s a leaf node and return true (Base case)
// If Node has one child (it must be left child because it is a complete tree) then we need to compare this node with its single child only.
// If Node has both child then check heap property at Node at recur for both subtrees.
private boolean isHeap(TreeNode root){
  //Base case : single node satisfies property
  if(root.left == null && root.right == null)
    return true;
  //node on second last level
  if(root.right== null)
    return root.key <= root.left.key;
  //other level nodes
  else{
    //Check heap property at Node and Recursive check heap property at left and right subtree
    if(root.key <= root.left.key && root.key <= root.right.key)
      return isHeap(root.left) && isHeap(root.right);
    else
      return false;
  }
}

//determine is a array is minheap
https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/
