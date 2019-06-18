//subroot node on one path
public int maxPathSum(TreeNode root){
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
}
//return the maxi path sum of the "single" path
private int helper(TreeNode root, int[] max){
    if (root == null)
        return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    // return a single path
    int sin = Math.max(left, right) + root.key;
    //max should be compare to single path 
    max[0] = Math.max(max[0], sin);
    return sin;
}
