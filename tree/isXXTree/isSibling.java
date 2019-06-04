private boolean isSibling(TreeNode root, TreeNode node1, TreeNode node2){
  // Base case
        if (node == null)
            return false;

        return ((node.left == a && node.right == b) ||
        (node.left == b && node.right == a) || 
        isSibling(node.left, a, b) ||
        isSibling(node.right, a, b));
}
