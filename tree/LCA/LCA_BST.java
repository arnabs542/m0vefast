//O(height)
public TreeNode LCA_BST(TreeNode root, TreeNode node1, TreeNode node2){
    if(root == null)
        return null;
    if(root.value < node1.value && root.value < node2.value)
        return LCA_BST(root.right, node1, node2);
    if(root.value > node1.value && root.value > node2.value)
        return LCA_BST(root.left, node1, node2);
    return root;
}