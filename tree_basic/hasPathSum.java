//given bst and an integer sum, determind if the tree has a root-to-left-path,
//such that path sum = the given sum
public boolean hasPathSum(TreeNode root, int sum){
    if(root == null)
        return false;
    if(root.left == null && root.right == null && root.val == sum)
        return true;
    boolean left = root.left != null ? hasPathSum(root.left, sum - root.val) : false;
    boolean right = root.right != null ? hasPathSum(root.right, sum-root.val) : false;
    return left || right;
}
