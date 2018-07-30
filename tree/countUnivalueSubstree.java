//A Uni-value subtree means all nodes of the subtree have the same value.
//similar to largestBST
public int countUnivalSubtrees(TreeNode root) {
    // Write your solution here
    int res = 0;
    helper(root, -1, res);
    return res;
  }
  //左右子节点分别都是相同值子树的根
  private boolean helper(TreeNode root, int value, int res){
    if(root == null)
      return true;
    // | bit operation, check both side: neither return true
    //如果左子节点存在，那么左子节点值需要和当前节点值相同，
    //如果右子节点存在，那么右子节点值要和当前节点值相同，
    if(!helper(root.left, root.vlaue, res) | !helper(root.right, root.vaue, res))
      return false;
    //若上述条件均满足的话，说明当前节点也是相同值子树的根节点，返回值再加1
    else
      res++;
    //左子节点值需要和当前节点值相同，右子节点值要和当前节点值相同，
    return root.value == value;
  }


//http://www.cnblogs.com/grandyang/p/5206862.html
//from bottom to top to check use post order traversal
// 那么我们可以从下往上check，采用后序遍历的顺序，左右根，我们还是递归调用函数，
// 对于当前遍历到的节点，如果对其左右子节点分别递归调用函数，返回均为true的话，
// 那么说明当前节点的值和左右子树的值都相同，那么又多了一棵树，所以结果自增1，
// 然后返回当前节点值和给定值(其父节点值)是否相同，从而回归上一层递归调用。
