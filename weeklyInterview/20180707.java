BST definition: left subroot.key < root.key
                Right subroot.key > root.key
                Left child is bst
                Right child is bst

Define a binary tree: root.children.size() < 2;
Is null or a treenode

class TreeNode{
    int key;
    List<TreeNode> children;
    public TreeNode(int key){
      this.key = key;
    }
  }

Check if its a binary tree
Check if bst
LCA for binary tree
LCA for bst
Inorder(iterative)
preOrder(recursion)

Recursive function: base case, go to the null
