//serialization: https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
//level oreder
//preorder
public String serialize(TreeNode root) {
    if(root==null)
        return null;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    StringBuilder sb = new StringBuilder();

    while(!stack.isEmpty()){
        TreeNode h = stack.pop();
        if(h!=null){
            sb.append(h.val+",");
            stack.push(h.right);
            stack.push(h.left);
        }else{
            sb.append("#,");
        }
    }
    //sb last char is #,
    return sb.toString().substring(0, sb.length()-1);
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if(data == null)
        return null;

    int[] t = {0};
    String[] arr = data.split(",");

    return helper(arr, t);
}

public TreeNode helper(String[] arr, int[] t){
    if(arr[t[0]].equals("#")){
        return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

    t[0]=t[0]+1;
    root.left = helper(arr, t);
    t[0]=t[0]+1;
    root.right = helper(arr, t);

    return root;
}

//https://www.programcreek.com/2015/01/leetcode-verify-preorder-serialization-of-a-binary-tree-java/
// "9,3,4,#,#,1,#,#,2,#,6,#,#",
//We can keep removing the leaf node until there is no one to remove.
// If a sequence is like "4 # #", change it to "#" and continue.
//  We need a stack so that we can record previous removed nodes.
public boolean isValidPreOrderBT(String preorder) {
   // Write your solution here
   LinkedList<String> stack = new LinkedList<String>();
    String[] arr = preorder.split(",");

    for(int i=0; i<arr.length; i++){
        stack.add(arr[i]);

        while(stack.size()>=3
            && stack.get(stack.size()-1).equals("#")
            && stack.get(stack.size()-2).equals("#")
            && !stack.get(stack.size()-3).equals("#")){

            stack.remove(stack.size()-1);
            stack.remove(stack.size()-1);
            stack.remove(stack.size()-1);

            stack.add("#");
        }
    }

    if(stack.size()==1 && stack.get(0).equals("#"))
        return true;
    else
        return false;
 }
 //1. nodes in left sub-tree are less than root node (find the first cut-point node
// 2. nodes in right sub-tree are greater than root node (You can return false if you have encountered any node that is less than the cut-point node value)
// 3. Is left sub-tree a binary search tree? (recursion to left)
// 4. Is right sub-tree a binary search tree? (recursion to right)
// 5. return left && right.

  private int end ;
  public boolean isValidPostOrderBST(int[] post) {
    if (post == null || post.length < 2)
      return true;
    end = post.length - 1;
    return helper(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
 //leftbound, rightbound
  private boolean helper(int[] post, int parentVal, int parentParentVal) { // parentParent's left child is the current's parent
    if (end < 0)
      return true;
    if (post[end] >= parentParentVal)
      return false; //shouldnt bigger than right
    if (post[end] <= parentVal)
      return true;  //smaller than right
    // TreeNode node = new TreeNode(post[end--]);
    int root = post[end];
    end--;  //left, right, root     end-- is right, end-- -- is left
    // node.right = helper(post, node.key);
    // node.left = helper(post, parentVal);
    // return node;
    //recursive check right, and check left
    return helper(post, root, parentParentVal) && helper(post, parentVal, root);
  }
