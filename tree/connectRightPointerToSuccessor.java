//in order sequence successor
public void connectToSuccessor(TreeNode root) {
   // Write your solution here.
   TreeNode pre = null;  //successor(leftmost of the rightsubtree)
   helper(root, pre);
   return;
 }
 //connect in a inorder way, post order to record the pre as the next traverse node's succesoor
 //backward tracking can reord the succsor for the next node
 //right root left   (as apposed to in order:left root right)
 private void helper(TreeNode root, TreeNode pre){
   if (root == null)
      return;
   helper(root.right, pre);
   if (root.right == null) {
     root.right = pre;
   }
   pre = root;
   helper(root.left, pre);
 }
