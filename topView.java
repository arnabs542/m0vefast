//topView of binary TreeNode
//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// A node x is there in output if x is the topmost node at its horizontal distance.
// Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
// and that of right child is horizontal distance of x plus 1.
//level order: queue
    7
  6   5      => 7654
4  3

//similar to vertical order traversal
public List<TreeNode> topView(TreeNode root){
  List<TreeNode> res = new ArrayList<>();
  if(root == null)
    return res;
  Set<Integer> set = new HashSet<>();  //the shadow top
  Queue<Item> queue = new LinkedList<>();
  queue.offer(new Item(root, 0));

  while(!queue.isEmpty()){
    Item cur = queue.poll();
    TreeNode node = cur.node;
    // If this is the first node at its horizontal distance,then this node is in top view
    if(!set.contains(cur.disToRoot)){
      set.add(cur.disToRoot);
      res.add(cur);
    }

    if(node.left !=null)
      queue.offer(new Item(node.left, cur.disToRoot-1));
    if(node.right !=null)
      queue.offer(new Item(node.right, cur.disToRoot+1));
  }
}
static class Item{
  TreeNode node;
  int disToRoot;
  public Item(TreeNode node, int dis){
    this.node = node;
    this.disToRoot = dis;  //colum number
  }
}
