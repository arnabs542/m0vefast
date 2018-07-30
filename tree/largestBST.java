//similar to isBST 时间复杂度为O(n2)，对于每一个节点，都来验证其是否是BST，如果是的话，我们就统计节点的个数即可
public int largestBSTSubtree(TreeNode root) {
    // Write your solution here
    if(root == null)
      return 0;
    if(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
      return count(root);
    else
      return Math.max(largestBST(root.left), largestBST(root.right));
  }
private boolean isValidBST(TreeNode root, int min, int max){
  if(root == null)
    return true;
  if(root.value <= min || root.value >= max)
    return false;
  else
    return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
}
private int count(TreeNode root){
  if(root == null)
    return 0;
  return 1 + count(root.left) + count(root.right);
}

//follow up: use O(n) use dfs
http://www.cnblogs.com/grandyang/p/5188938.html
