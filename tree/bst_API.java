//insert a node in bst
//resurcion
public TreeNode insertNode(TreeNode root, int target) {
    if(root == null){
        return new TreeNode(target);
    }
    if(target < root.key){
        root.left = insertNode(root.left, key);
    }else if(target > root.key){
        root.right = insertNode(root.right, key);
    }
    return root;
}
//iterative
public TreeNode insertNode(TreeNode root, TreeNode node){
    if(root == null)
        return node;
    TreeNode cur = root;
    while(true){
        if(node.val < cur.val){
            if(cur.left != null)
                cur = cur.left;
            else{
                cur.left = node;
                break;
            }
        }else if(node.val > cur.val){
            if(cur.right != null)
                cur = cur.right;
            else{
                cur.right = node;
                break;
            }
        }else{
            cur.val = node.val;
            break;
        }
    }
    return root;
}
//delete a node in bst, assuming target exist
public TreeNode delete(TreeNode root, int target){
    if(root == null)
        return null;
    if(root.value < target){
        root.right = delete(root.right, target);
    }else if(root.value > target){
        root.left = delete(root.left, target);
    }else{  //root.key == key
        if(root.left == null && root.right == null){ //case 1
            return null;
        }else if(root.left == null || root.right == null){ //case 2
            return root.left == null ? root.right : root.left;
        }else if(root.right.left == null){//case 3
          root.right.left = root.left;  //3.1 if root.right.left == null
          return root.right;
        }else{   //3.2 if root.right.left != null
            TreeNode smallest = findSmallest(root.right);
            root.value = smallest.value;
            root.right = delete(root.right, smallest.value)
        }
    }
    return root;
}
private TreeNode findSmallest(TreeNode root){
    while(root.left.left != null)
        root = root.left;
    TreeNode smallest = root.left;
    root.left = root.left.right; //important delete smallest by changing pointer
    return smallest;
}
//search a node in bst
//solution1: tail recursive version O(height) O(height)
public TreeNode search(TreeNode root, int target){
    if(root == null)
        return null;
    if(root.value == target)
        return root;
    else if(root.value > target)
        return search(root.left, target);
    else
        return search(root.right, target);
}
//solution2: iterative O(height) O(1)
public TreeNode search(TreeNode root, int target){
    while(root != null){
        if(root.value == target){
            return root;
        }else if(root.value > target){
            root = root.left;
        }else{
            root = root.right;
        }
    }
    return null;
}
//count all nodes
int getLeafCount(Node node)
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }
//inorder successor
//recurvie solution
public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
  if(root == null || p == null)
    return null;
  if(root.val <= p.val)
    return inorderSuccessor(root.right, p);
  else{
    TreeNode res = inorderSuccessor(root.left, p);
    if(res == null)
      return root;
    return res;
    //return (left != null)? left : root;
  }
}
//iteration solution
http://www.jiuzhang.com/solution/inorder-successor-in-binary-search-tree/

//sortedArrayToBST
public TreeNode sortedArrayToBST(int[] A) {
    // write your code here
    int len = A.length-1;
    TreeNode root = null;
    root = recursion(A, 1, len, root);
    A = null;
    return root;
}
public TreeNode recursion(int[] array, int lhs, int rhs, TreeNode root){
    if(lhs <= rhs){
        int mid = lhs + (rhs - lhs)/2;
        root = new TreeNode(array[mid]);
        root.left = recursion(array, lhs, mid - 1, root.left);
        root.right = recursion(array, mid + 1, rhs, root.right);
    }
    return root;
}
