//from left to root != null
//solution1:
public int maxPathSum(TreeNode root){
    return helper(root, 0)
}
//return the maxi path sum of the "single" path
private int helper(TreeNode root, int[] max){
    prefixSum += root.key;
    if(root.left == null && root.right == null)
        return prefixSum;
    else if(root.left == null)
        return helper(root.right, prefixSum);
    else if(root.right == null)
        return helper(root.left, prefixSum);
    return Math.max(helper(root.left, prefixSum),
                    helper(root.right, prefixSum));
}
//solution2
private int maxPathSum(TreeNode root){
    prefixSum += root.key;
    if(root.left == null && root.right == null)
        return root.key;
    else if(root.left == null)
        return helper(root.right) + root.key;
    else if(root.right == null)
        return helper(root.left) + root.key;
    return root.key + Math.max(helper(root.left), helper(root.right));
}