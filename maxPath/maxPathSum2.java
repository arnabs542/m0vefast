//from leaf to leaf
public int maxPathSum(TreeNode root){
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
}
//return the value is the max path sum from root to any leaf node in its subtree
private int helper(TreeNode root, int[] max){
    if (root == null)
        return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    //only when root node has both child, we might update max path sum
    if(root.left != null && root.right != null){
        max[0]=Math.max(max[0], left+right+root.key);
        return Math.max(left, right) +  root.key;
    }
    if(root.left == null)
        return right+root.key;
    else
        return left+root.key
}