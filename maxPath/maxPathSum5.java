//subroot node on one path : target
public boolean exist(TreeNode root, int sum){
    if(root == null)
        return false;
    List<TreeNode> path = new ArrayList<>();
    return helper(root, path, sum);
}
private boolean helper(TreeNode root, List<TreeNode> path, int sum){
    path.add(root);
    //check if can find a subpath ended at root node, the sum of the path is target
    int temp = 0;
    for(int i = path.size() - 1; i>= 0; i--){
        temp += path.get(i).key;
        if(temp == sum)
            return true;
    }
    if(root.left != null && helper(root.left, path, sum))
        return true;
    if(root.right != null && helper(root.right, path, sum))
        return true;
    //clean up when return tot he previou level
    path.remove(path.size() - 1)
    return false;
}
//solution2: O(n)
public boolean exist(TreeNode root, int sum){
    if(root == null)
        return false;
    Set<Integer> prefixSums = new HashSet<>();
    return helper(root, prefixSums, 0, sum);
}
private boolean helper(TreeNode root, Set<Integer> prefixSums, int preSum, int sum){
    preSum += root.key;
    if(prefixSums.contains(preSum - sum))
        return true;
    boolean needRemove = prefixSums.add(preSum);
    if(root.left != null && helper(root.left, prefixSums, preSum, sum))
        return true;
    if(root.right != null && helper(root.right, prefixSums, preSum, sum))
        return true;
    if(needRemove)
        prefixSums.remove(preSum);
    return false;
}
