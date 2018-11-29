//recursion:
public int totalNode(TreeNode root){
  int total_height = height(root);
  int right_height = height(root.right);
  if(right_height == total_height - 1)
    // left right has same height, total_left(left is full tree 2^(h-1)) + 1(root) + recursive(right)
    //left full tree size: 2^h - 1
    return power(total_height) - 1 + 1 + totalNode(root.right);
    // right full tree size: 2 ^(h-1) -1
    // right starts to be shorter: total_right(right is full tree 2^(h-2)) + 1 recursive(left),
  return power(total_height-1) - 1 + 1  + totalNode(root.left);
}
private int height(TreeNode root){
  if(root == null)
    return -1;
  return 1 + height(root.left);
}
private int power(int h){
  int res = 1;
  for(int i = 0; i < h; i++){
    res = res * 2;
  }
  return res;
}
//itertion + counter: exceed time limit
public int totalNode(TreeNode root){
  if(root == null)
    return 0;
  int counter = 0;
  Stack<TreeNode> stack = new Stack<>();
  TreeNode cur = root;
  while(cur != null || stack.isEmpty()){
    while(cur != null){
      stack.push(cur);
      cur = cur.left;
    }
    cur = stack.pop();
    counter++;
    cur = cur.right;
  }
  return counter;
}
