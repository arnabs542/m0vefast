//each node its value is equal to the sum of all nodes greater than itself.
// Recursive function to transform a BST to sum tree.
// This function traverses the tree in reverse inorder so
// that we have visited all greater key nodes of the currently
// visited node
public TreeNode transformTree(TreeNode root){
    int sum = 0; // Initialize sum
    helper(root, sum);
    return root;
}
private void helper(TreeNode root, int sum){
   // Base case
   if (root == NULL)
    return;
   helper(root.right, sum);
   // Update sum
   sum += root.key
   // Store old sum in current node
   root.key = sum - root.key;
   helper(root.left, sum);
}
 // Method 2 (Using only one traversal)
 // By leveraging the fact that the tree is a BST, we can find an O(n) solution. The idea is to traverse BST in reverse inorder.
 // Reverse inorder traversal of a BST gives us keys in decreasing order. Before visiting a node, we visit all greater nodes of that node.
 // While traversing we keep track of sum of keys which is the sum of all the keys greater than the key of current node.
