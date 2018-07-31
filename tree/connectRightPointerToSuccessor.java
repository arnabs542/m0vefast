public void connect(TreeNode root) {
   // Write your solution here.
   TreeNode pre = null;
   helper(root, pre);
   return;
 }
 //connect in a inorder way 
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
