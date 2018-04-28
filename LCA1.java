public TreeNode LCA1(TreeNode root, TreeNode node1, TreeNode node2){
    //basecase: found? report itself to parent; not found? report null to parent
    //if(root == null || root == node1 || root == node2)  
    //    return root;
    if(root == null)
      return null;  
    if(root == node1 || root == node2)
      return root;
    //Divide 用于从下往上返值的情况
    TreeNode left = LCA1(root.left, node1, node2);
    TteeNode right = LCA1(root.right, node1, node2);
    //conquer, recursion rule
    if(left != null && right != null)   //if 不直接隶属情况
        return root;
    return left == null? right : left;  //不直接隶属情况 + 直接隶属情况
}

recursion rule:
1不直接隶属: 
1) both left and right are null, return null to parent  //basecase, node1 and node2 not in tree
2) either left or right is null, return non-null side to parent  
(3) both not null, return parent 
2直接隶属:
1) both left and right are null, return null to parent  //basecase
2) either left or right is null, return non-null side to parent  
//3) both not null, return parent