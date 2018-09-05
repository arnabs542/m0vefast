//determine is a tree is minheap
// It should be a complete tree (i.e. all levels except last should be full).
// Every node’s value should be smaller than or equal to its child node (considering min-heap).
public boolean isMinHeap(TreeNode root){
  if(root == null)
    return true;
  int amount_nodes = countNodes(root);
  return (isComplete(root, 0, amount_nodes) && isHeap(root, root.key));
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
private boolean checkMinHeap(TreeNode root, int bound){
  if(root == null)
    return true;
  if(root.key < bound)
    return false;
  return helper(root.left, root.key) && helper(root.right, root.key);
}


//determine is a array is minheap
https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/
