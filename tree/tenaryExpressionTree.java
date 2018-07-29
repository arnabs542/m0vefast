//fb //a?b?c:d:e a[b(cd)e] similar to isValidPreOrderBT
//solution1: recursive
//Idea is that we traverse a string make first character as root and do following step recursively .
// 1. If we see Symbol ‘?’, then we add next character as the left child of root.
// 2. If we see Symbol ‘:’, then we add it as the right child of current root.
public TreeNode tenaryToTree(String s) {
    return helper(s.toCharArray(), 0);
}
private TreeNode helper(char[] arr, int index){
  if(i >= arr.length)
    return null;
  TreeNode root = new TreeNode(arr[i]);
  i++;
  //if current character of ternary expression is '?'
  if(i < arr.length && arr[i] == '?')
    root.left = helper(arr, i+1);
  // else we have to add it as a right child of current node expression.at(0) == ':'
  else if(i < arr.length)  //&& arr[i] == ':')
    root.right = helper(arr, i+1)
  return root;
}
//solution2: iterative using stack  //a?b?c:d:e a[b(cd)e]
public TreeNode tenaryToTree(String s) {
    if (s.length() == 0)
        return null;

    TreeNode root = new TreeNode(s.charAt(0));
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == '?') {
            TreeNode node = stack.peek();  //peek is the will have left child on current node
            node.left = new TreeNode(s.charAt(i + 1));
            stack.push(node.left);
        } else if (s.charAt(i) == ':') {
            stack.pop(); //pop root's left  abc->ad(=b.right)
            TreeNode node = stack.pop(); //pop root
            node.right = new TreeNode(s.charAt(i + 1));
            stack.push(node.right);  //push root's right,
            //will be next dealing with node(h) ad->e(=a.right)
        }
    }

    return root;
}

 /**
  * public class ExpNode {
  *   public char symbol;
  *   public ExpNode left;
  *   public ExpNode right;
  *   public ExpNode(char symbol) {
  *     this.symbol = symbol;
  *   }
  * }
  */

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
