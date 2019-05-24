//from left to rightS, if same vertical distance, then from top to bottom (level order)
//https://piazza.com/class/j0eqhhdregb3i?cid=2721
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if(root == null)
      return res;
    //<disToRoot, listOF(node_values)>
    Map<Integer, List<Integer>> map = new TreeMap<>();
    Queue<Item> queue = new LinkedList<>();
    queue.offer(new Item(0, root));
    //不需要先放左边的node进result，你依然可以从上到下的顺序遍历，use linkedlist offerlast and offerfirst
    while(!queue.isEmpty()){
      Item cur = queue.poll();
      TreeNode node = cur.node;
      //process res
      if(!map.contiansKey(cur.disToRoot)){
        map.put(cur.disToRoot, new ArrayList<>());
      }
      map.get(cur.disToRoot).add(node.key);  //level order for the nodes with the same distance

      if(node.left !=null)
        queue.offer(new Item(node.left, cur.disToRoot-1));
      if(node.right !=null)
        queue.offer(new Item(node.right, cur.disToRoot+1));
    }
    for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
      res.add(entry.getValue());
    }
    return res;
  }

  static void printVertically(TreeNode root, TreeMap<integer, linkedlist<integer="">> result, int level) {
          if (root == null) {
              return;
          }

          LinkedList<integer> list = result.get(level);
          if (list == null) {
              list = new LinkedList<>();
          }
          list.add(root.data);
          result.put(level, list);

          printVertically(root.left, result, level-1);

          printVertically(root.right, result, level+1);
      }


//topView of binary TreeNode
//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// A node x is there in output if x is the topmost node at its horizontal distance.
// Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
// and that of right child is horizontal distance of x plus 1.
//level order: queue
    7
  6   5      => 7654
4  3

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
