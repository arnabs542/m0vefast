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
  Set<Integer> showdow = new HashSet<>();  //the shadow top
  Queue<Item> queue = new LinkedList<>();
  queue.offer(new Item(root, 0));

  List<Item> temp = new ArrayList<>();
  while(!queue.isEmpty()){
    Item cur = queue.poll();
    TreeNode node = cur.node;
    // If this is the first node at its horizontal distance,then this node is in top view
    if(!shadow.contains(cur.disToRoot)){
      shadow.add(cur.disToRoot);
      temp.add(cur.node.key);
    }

    if(node.left !=null)
      queue.offer(new Item(node.left, cur.disToRoot-1));
    if(node.right !=null)
      queue.offer(new Item(node.right, cur.disToRoot+1));
  }
  Collections.sort(temps, (i1, i2)->i1.dist - i2.dist));
  // Collections.sort(temp, new Comparator<Item>() {
  //       @Override
  //     public int compare(Item p1, Item p2) {
  //           return p1.dist - p2.dist; // Ascending
  //       }
  //   });
  for(Item each : temp){
    res.add(each.node.key);
  }
  return res;
}
