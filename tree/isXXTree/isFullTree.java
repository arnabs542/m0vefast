//0 or 2 children
public boolean isFull(TreeNode root) {
        // if empty tree
    if(node == null)
        return true;

        // if leaf node
        if(node.left == null && node.right == null )
            return true;

        // if both left and right subtrees are not null
        // the are full
        if((node.left!=null) && (node.right!=null))
            return isFullTree(node.left) && isFullTree(node.right);

        // if none work
        return false;
    }
  }
