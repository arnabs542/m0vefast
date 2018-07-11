//mathpathsum
//node to node
public int mathpathsum(TreeNode root){
    int[] max = new int[0]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
}
private int helper(TreeNode root, int[] max){
    if(root == null)
        return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    left = left > 0 ? left : 0;
    right = right > 0 ? right : 0;
    max[0] = Math.max(max[0], root.key + left + right);
    return root.key + Math.max(left, right);
}
//leaf to leaf
private int helper(TreeNode root, int[] max){
    if(root == null)
        return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    if(root.left != null && root.right != null){
        max[0] = Math.max(max[0], root.key + left + right);
        return root.key + Math.max(left, right);
    }
    if(root.left != null)
        return root.key + left;
    if(root.right != null)
        return root.key + right;
    return root.key;
}
//root to node
// public int mathpathsum(TreeNode root){

// }
//root to leaf/leaf to root
public int mathpathsum(TreeNode root){
    if(root == null)
        return 0;
    if(root.left != null && root.right != null)
        return root.key;
    if(root.left != null)
        return root.key + maxPathSum(root.left);
    if(root.right != null)
        return root.key + maxPathSum(root.right);
    int left = maxPathSum(root.left);
    int right = maxPathSum(root.right);
    return root.key + Math.max(left, right);
}
//root to leaf one path (similar: node - node but no compare)
private int helper(TreeNode root, int[] max){
    if(root == null)
        return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    max[0] = Math.max(max[0], root.key + Math.max(0, Math.max(left, right)));
    return root.key + Math.max(0, Math.max(left, right));
}
