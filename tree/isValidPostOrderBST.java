//solution1: Time: O(nlogn)  Space: O(1)
 //https://github.com/xieqilu/Qilu-leetcode/blob/master/B206.ValidatePostorderTraversalBST.cs
 public boolean isValidPostOrderBST(int[] post){
   return helper(post, 0, post.length-1);
 }
 //Helper method for checking if the postorder array is a valid BST
 private boolean helper(int[] nodes, int start, int end){
   if(end <= start)  //empty tree and a tree has only one node are BST
     return true;
   int root = nodes[end]; //current root value
   int i = end-1;
   //all index of right substree
   while(i >= start && nodes[i] > root){
     i--;
   }
   int left = i;
   //all index of left substree
   while(i >= start && nodes[i] < root){
     i--;
   }
   //is should be finishing traversing left subtree
   //If i is equal to start-1(i should be out of subtree index range), it could be a valid BST for current subtree
   if(i != start-1)
     return false;
   //Recursively check left subtree and right subtree
   return ValidateBSTHelper(nodes, start, left) && ValidateBSTHelper(nodes,left+1,end-1);
 }
//solution2: construct tree -> isValidBST   Time: O(nlogn)  Space: O(n)
 // There are two important facts we need to know as follows:
 // 1, We cannot construct a Binary Tree only using its PostOrder traversal list. There could be multiple binary trees that
 // have the same PostOrder traversl list. However, we can construct a BT using pre-in order traversal or in-post order traversal.
 // 2, But if we are dealing with a Binary Search Tree, things are quite different. We can construct a BST using only Postorder
//traversal list. Because a BST is actually sorted, its inorder traversal is sorted, so a BST has a unique postorder traversal.
public TreeNode reconstruct(int[] post) {
   // Write your solution here.
   int[] index = new int[]{post.length-1};
   return helper(post, index, Integer.MIN_VALUE);
 }
 private TreeNode helper(int[] post, int[] index, int min){
   if(index[0] < 0 || post[index[0]] <= min){
     return null;
   }
   TreeNode root = new TreeNode(post[index[0]--]);
   root.right = helper(post, index, root.key);
   root.left = helper(post, index, min);

   return root;

 }
public boolean isBST(TreeNode root){
 return helper(root, Integer.MAX_VALUE, Integer.)
}
