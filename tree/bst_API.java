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
    root.left = root.left.right; //important
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
