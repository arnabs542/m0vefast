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
    int sin = Math.max(Math.max(left, right), 0) + root.key;
    max[0] = Math.max(max[0], sin);
    return sin;
}