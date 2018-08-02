//microsoft   or target node.value = x   post order 
//https://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
public TreeNode deleteZeroLeafNode(TreeNode root, int x) {
    // Write your solution here
    if(root == null)
      return null;
    root.left = deleteZeroLeafNode(root.left, x);
    root.right = deleteZeroLeafNode(root.right, x);
    if(root.key == x && root.left == null && root.right == null){
      root = null;  //delete(root);
      return null;
    }
    return root;
  }
