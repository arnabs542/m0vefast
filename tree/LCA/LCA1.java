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

public class Solution{
     public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){
          ResultType res = helper(root, node1, node2);
          if(res.a_exist && res.b_exist)
               return res.node;
          else return null;
     }
     public ResultType helper(TreeNode root, TreeNode node1, TreeNode node2){
          if(root == null)
               return new ResultType(false, false, null);

          ResultType leftRes = helper(root.left, node1, node2);
          ResultType rightRes = helper(root.right, node1, node2);

          boolean a_exist = leftRes.a_exist || rightRes.a_exist || root == node1;
          boolean b_exist = leftRes.b_exist || rightRes.b_exist || root == node2;

          if(root == node1 || root == node2)
               return new ResultType(a_exist, b_exist, root);
          if(leftRes.node != null && rightRes.node != null)
               return new ResultType(a_exist, b_exist, root);
          if(leftRes.node != null)
               return new ResultType(a_exist, b_exist, leftRes.node);
          if(rightRes.node != null)
               return new ResultType(a_exist, b_exist, rightRes.node);
          //non-existance in given tree
          return new ResultType(a_exist, b_exist, null);
     }
}
