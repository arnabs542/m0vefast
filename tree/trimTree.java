//trim path len <= k
// Method which calls the utitlity method to remove the short path treenode
   public TreeNode removeShortPathTreeNodes(TreeNode TreeNode, int k){
       //int pathLen = 0;
       return helper(TreeNode, 1, k);
   }
   private TreeNode helper(TreeNode root, int level, int k){
          //Base condition
          if (TreeNode == null)
              return null;

          // Traverse the tree in postorder fashion so that if a leaf
          // TreeNode path length is shorter than k, then that TreeNode and
          // all of its descendants till the TreeNode which are not
          // on some other path are removed.
          root.left = helper(root.left, level + 1, k);
          root.right = helper(root.right, level + 1, k);

          // If root is a leaf TreeNode and it's level is less than k then
          // remove this TreeNode.
          // This goes up and check for the ancestor TreeNodes also for the
          // same condition till it finds a TreeNode which is a part of other
          // path(s) too.
          if (root.left == null && root.right == null && level < k)
              return null;

          return root;
      }


  // The idea here is to use post order traversal of the tree. Before removing a TreeNode we need to check that all the children of that TreeNode in the shorter path are already removed.
  // There are 2 cases:
  // i) This TreeNode becomes a leaf TreeNode in which case it needs to be deleted.
  // ii) This TreeNode has other child on a path with path length >= k. In that case it needs not to be deleted.
