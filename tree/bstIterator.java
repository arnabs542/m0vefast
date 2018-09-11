public class BSTIterator{
  private Deque<TreeNode> stack;
  public BSTIterator(TreeNode root){
    stack = new LinkedList<>();
    while(root.left != null){
      stack.offer(root);
      root = root.left;
    }
  }
  public boolean hasNext(){
    return !stack.isEmpty();
  }
  public int next(){
    int cur = stack.poll();
    int res = cur.res;
    if(cur.right != null){
      cur = cur.right;
      while(cur != null){
        stack.offer(cur);
        cur = cur.left;
      }
    }
    //else{
    // if leaf node, then continue pop
    //}

  }
  return res;
}
public List<TreeNode> inOrder(TreeNode root){
  List<TreeNode> res = new ArrayList<>();
  if(root = null)
    return res;

  Deque<TreeNode> stack = new LinkedList<>();
  TreeNode cur = root;

  while(cur != null || !stack.isEmpty()){
    while(cur != null){
      stack.offer(cur);
      cur = cur.left;
    }
    cur = stack.poll();
    res.add(cur);
    cur = cur.right;
  }
  return res;
}
