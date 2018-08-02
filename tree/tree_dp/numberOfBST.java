https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
//If 1 to i-1 can form x different trees and i+1 to N can from y different trees then we will have x*y total trees when ith number is root
// and we also have N choices for root also so we can simply iterate from 1 to N for root and another loop for left and right subtree.
public int numOfBST(int n){
  if(n < 0)
    return 0;
  int[] dp = new int[n+1];
  dp[0] = 1;
  //for each choice of root
  for(int level = 1; level <= n; level++){
    for(int root = 1; root <= level; root++){
      //number of left subtree * number of right subtree
      dp[level] += dp[level-root] * dp[root-1];
    }
  }
  return dp[n];
}
//The idea is to maintain a list of roots of all BSTs. Recursively construct all possible left and right subtrees.
// Create a tree for every pair of left and right subtree and add the tree to list. Below is detailed algorithm.
// 1) Initialize list of BSTs as empty.
// 2) For every number i where i varies from 1 to N, do following
// ......a)  Create a new node with key as 'i', let this node be 'node'
// ......b)  Recursively construct list of all left subtrees.
// ......c)  Recursively construct list of all right subtrees.
// 3) Iterate for all left subtrees
//    a) For current leftsubtree, iterate for all right subtrees
//         Add current left and right subtrees to 'node' and add
//         'node' to list.

//non dp solution
public int numOfBST(int n){
  return helper(1, n).size();
}
private List<TreeNode> helper(int start, int end){
  List<Integer> res = new ArrayList<>();
  if(start > end){
    //res.add(null);
    return res;
  }
  for(int i = start; i <= end; i++){
    List<TreeNode> leftSub = helper(start, i-1);
    List<TreeNode> rightSub = helper(i+1, end);
    //for each node on left
    for(int j = 0; j < left.size(); j++){
      // TreeNode left = leftSub[j];
      //for each node on the right
      for(int k = 0; k < rightSub.size(); k++){
        // TreeNode right = rightSub[k];
        TreeNode root = new TreeNode(i);
        // root.left = left;
        // root.right = right;
        res.add(root);
        //count++;
      }
    }
  }
  return res;
  //return count++;
}
