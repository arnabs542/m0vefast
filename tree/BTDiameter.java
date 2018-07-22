// The diameter is defined as the longest distance from one leaf node to another leaf node.
//node to node: find max sum
//node to node: find max length
// Hence the diameter of a binary tree T will be the largest of the following quantities:
//
// the diameter of T’s left subtree
// the diameter of T’s right subtree
// the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
public int diameter(TreeNode root) {
  return helper(root, height(root));
}

private int height(TreeNode root){
  if(root == null)
    return 0;
  return Math.max(height(root.left), height(root.right)) + 1;
}
//return diameter/width of a tree
private int helper(TreeNode root, int height){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int dia_left = helper(root.left, leftHeight);
        int diar_right = helper(root.right, rightHeight);
        //root.height = Math.max(leftHeight.height, rightHeight.height) + 1;
        return Math.max(Math.max(dia_left, diar_right),
                      (1 + leftHeight + rightHeight));
    }
