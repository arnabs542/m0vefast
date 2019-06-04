//same level but diferent parents
public boolean isCousins(TreeNode root, int a, int b){
  return level(root, a, 1) != level(root, b, 1)
         && !isSibling(root, a, b);
}
// retur the depth of the given node
private int level(TreeNode root, TreeNode node, int level){
  if(root == null)
    return 0;
  if(root == node)
    return level;
  //return level if root is present in left subtree
  int l = level(root.left, node, level+1);
  if(l != 0)
    return l;
  else // Else search in right subtree
    return level(root.right, node, level+1);
}

//print all cousins of a node
http://massivealgorithms.blogspot.com/2016/07/print-cousins-of-given-node-in-binary.html
public void printAllCounsins(TreeNode root, TreeNode node){
  int level = level(root, node, 1);
  printTree(root, node, level);
}
private void printTree(TreeNode root, TreeNode node, int level)
    if (root == NULL || level < 2)
        return;
    // If current node is parent of a node with
    // given level
    if (level == 2){
        if (root->left == node || root->right == node)
            return;
        if (root->left)
           printf("%d ", root->left->data);
        if (root->right)
           printf("%d ", root->right->data);
    }
  // Recur for left and right subtrees
    else if (level > 2){
        printGivenLevel(root->left, node, level-1);
        printGivenLevel(root->right, node, level-1);
    }
}
