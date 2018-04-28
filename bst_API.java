public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }}


// Version 2: without ResultType, preorder

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;   //null.height == 0
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


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
//kth smallest elemtn in bst
public int kthSmallest(TreeNode root, int k){
    int leftSize = count(root.left);
    if(k <= leftSize)
        return kthSmallest(root.left, k);
    else if(k == leftSize + 1)
        return root.val;
    else
        return kthSmallest(root.right, k-leftSize-1);
}
private int count(TreeNode root){
    if(root == null)
        return 0;
    return 1 + count(root.left) + count(root.right);
}
//given bst and an integer sum, determind if the tree has a root-to-left-path,
//such that path sum = the given sum
public boolean hasPathSum(TreeNode root, int sum){
    if(root == null)
        return false;
    if(root.left == null && root.right == null && root.val == sum)
        return true;
    boolean left = root.left != null ? hasPathSum(root.left, sum - root.val) : false;
    boolean right = root.right != null ? hasPathSum(root.right, sum-root.val) : false;
    return left || right;
}
