//kth smallest elemtn in bst
public int kthSmallest(TreeNode root, int k){
    int leftSize = count(root.left);
    if(k <= leftSize)
        return kthSmallest(root.left, k);
    else if(k == leftSize + 1)
        return root.val;
    else
        return kthSmallest(root.right, k-leftSize-1);
}
private int count(TreeNode root){
    if(root == null)
        return 0;
    return 1 + count(root.left) + count(root.right);
}
