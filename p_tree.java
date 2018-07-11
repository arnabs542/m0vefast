public boolean isBalanced(TreeNode root){
  return getHeight(root) != -1;
}
private int getHeight(TreeNode root){
  if(root == null)
    return 0;
  int left = getHeight(root.left);
  int right = getHeight(root.right);
  if(left == -1 || right == -1 || Math.abs(left - right) > 1){
    return -1;
  }
  return Math.max(left, right) + 1;
}
//recursion
public TreeNode search(TreeNode root, int target){
  if(root == null)
    return null;
  if(root.value == target)
    return root;
  else if(root.value < target)
    return search(root.left, target);
  else
    return search(root.right, target);
}
//iterative
public TreeNode search(TreeNode root, int target){
  if(root == null)
    return null;
  while(root != null){
    if(root.value == target){
      return root;
    }else if(root.value < target){
      root = root.left;
    }else{
      root = root.right;
    }
  }
  return null;
}
public TreeNode delete(TreeNode root, int target){
  if(root == null)
    return null;
  //target on right tree
  if(root.value < target){
    return delete(root.right, target);
  //target on left tree
  }else if(root.value > target){
    return delete(root.left, target);
  //target is the root
  }else{
    //no child
    if(root.left == null && root.right == null)
      return null;
    //only one child
    if(root.left == null || root.right == null)
      return root.left == null ? root.right : root.left;
    //two children
    //with no successor
    if(root.right.left == null){
      root.right.left = root.left;
      //root = root.right;
      return root.right;
    }else{//with successor
      TreeNode successor = findSmallest(root.right);
      root.value = successor.value;
      //delete(root.right, successor.value);
      root.right = delete(root.right, successor.value);
    }
  }
  return root;
}
private TreeNode findSmallest(TreeNode root){
  while(root.left.left != null){
    root = root.left;
  }
  return root.left;
}
public TreeNode insert(TreeNode root, int value){
  if(root == null){
    return new TreeNode(value);
  }
  if(root.value < value){
    return insert(root.right, value);
  else if(root.value > value){
    return insert(root.left, value);
  }
  return root;
}
//level order
public boolean isComplete(TreeNode root){
  if(root == null)
    return true;
  Queue<Integer> queue = new LinkedList<>();
  queue.offer(root);
  boolean flag;
  while(!queue.isEmpty()){
    TreeNode cur = queue.poll();
    if(root.left != null){
      flag = true;
    }else if(flag){
      return false;
    }else{
      queue.offer(root.left);
    }
    if(root.right != null){
      flag = true;
    }else if(flag){
      return false;
    }else{
      queue.offer(root.right);
    }
  }
  return true;
}
//in order traversal
public List<Integer> getKeyInRange(TreeNode root, int min, int max){
  List<Integer> res = new ArrayLsit<>();
  return helper(root, res, min, max);
}
private List<Integer> helper(TreeNode root, List<Integer> res, int min, int max){
  if(root == null)
    return res;
  if(root.key > min){
    return getKeyInRange(root.left, min, max);
  else if(root.key <= max && root.key >= min)
    res.add(root.key);
  }else if(root.key < max)
    return getKeyInRange(root.right, min, max);
  }
  return res;
}
//in order
public int kthSmallest(TreeNode root, int k){
  if(root == null)
    return -1;
  int left_size = count(root.left);
  if(left_size >= k)
    return kthSmallest(root.left, k);
  else if(left_size + 1 = k)
    return root.key;
  else
    return kthSmallest(root.right, k - left_size);
}
private int count(TreeNode root){
  if(root == null)
    return 0;
  return 1 + count(root.left) + count(root.right);
}
public boolena isBST(TreeNode root){
  return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
}
private boolean helper(TreeNode root, int min, int max){
  if(root == null)
    return true;
  if(root.key <= min || root.key >= max)
    return false;
  return helper(root.left, min, root.key) && helper(root.right, root.key, max);

}
//recursion
public TreeNode reverse(TreeNode root){
  if(root == null || root.left == null)
    return root;
  TreeNode newRoot = reverse(root.left);
  root.left.left = root.right;
  root.left.right = root;
  root.left = null;
  root.right = null;
  return newRoot;
}
public boolean isTweakedTree(TreeNode one, TreeNode two){
  if(root == null)
    return true;
  return (isTweakedTree(one.left, two.left) && isTweakedTree(one.right, two.right)) ||
  (isTweakedTree(one.left, two.right) && isTweakedTree(one.right, two.left))

}
public boolean isIdentical(TreeNode root){
  if(root == null)
    return true;
  return isIdentical(one.left, two.left) && isIdentical(one.right, two.right)
}
public List<Integer> preOrder(TreeNode root){
  List<Integer> res = new ArrayList<>();
  if(root == null)
    return null;
  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerFirst(root);
  while(!stack.isEmpty()){
    TreeNode cur = stack.pollFirst();
    res.add(cur);
    if(cur.right != null){
      res.add(0, cur.right);
    }
    if(cur.left != null(){
      res.add(0, cur.left);
    }
  }
  return res;

}
public List<Integer> inOrder(TreeNode root){
  List<Integer> res = new ArrayList<>()
  if(root == null)
    return res;
  TreeNode cur = root;
  Deque<TreeNode> stack = new LinkedList<>();
  while(cur != null || stack.isEmpty()){
    while(cur != null){
      stack.offerFirst(cur);
      cur = cur.left;
    }
    cur = stack.pollFirst();
    res.add(cur.key);
    cur = cur.right;
  }
}
public List<Integer> postOrder(TreeNode root){
  List<Integer> res = new ArrayList<>();
  if(root == null)
    return null;
  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerFirst(root);
  while(!stack.isEmpty()){
    TreeNode cur = stack.pollFirst();
    res.add(cur);
    if(cur.left != null){
      res.add(0, cur.left);
    }
    if(cur.right != null(){
      res.add(0, cur.right);
    }
  }
  return res;
}
public List<Integer> levelOrder(TreeNode root){
  List<Integer> res = new ArrayList<>();
  if(root== null)
    return res;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);

  while(!queue.isEmpty()){
    int size = queue.size();
    for(int i = 0; i < size; i++){
      TreeNode cur = queue.poll();
      res.add(cur.key);
      if(cur.left != null)
        queue.offer(cur.left);
      if(cur.right != null)
        queue.offer(cur.right);
    }
  }
  return res;
}
public List<Integer> zigZag(TreeNode root){
  List<Integer> res = new ArrayList<>();
  if(root == null)
    return res;

  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerLast(root);
  int layer = 0;

  while(!queue.isEmpty()){
    int size = queue.size();
    for(int i = 0; i < size; i++){
      if(layer == 0){
        TreeNode cur = queue.pollLast();
        res.add(cur.key);
        if(cur.right != null)
          stack.offerFirst(cur.right);
        if(cur.left != null)
          stack.offerFirst(cur.left);
      }else{
        TreeNode cur = queue.pollFirst();
        res.add(cur.key);
        if(cur.left != null)
          stack.offerLast(cur.left);
        if(cur.right != null)
          stack.offerLast(cur.right);
      }
    }
    layer = 1 - layer;

    }

  return res;
}
//LCA
//0) bianry tree - 2 node
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  if(root == nuoll)
    return null;
  if(root == one || root == two)
    return root;
  TreeNode left = LCA(root.left, one, two);
  TreeNode right = LCA(root.right, one, two);
  if(left != null && right != null)
    return root;
  return left != null ?  left : right;
}
//1) with parent pointer
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  if(root == nuoll)
    return null;
  if(root == one || root == two)
    return root;
  List<TreeNode> one = getPath2Root(root, one);
  List<TreeNode> two = getPath2Root(root, two);
  int index1 = one.size()-1;
  int index2 = two.size()-1;
  TreeNode res = null;
  while(index1 > 0 && index2 > 0){
    if(one.get(index1) == two.get(index2)){
      res = one.get(index1);
    }
    index1--;
    index2--;
  }
  return res;
}
private List<TreeNode> getPath2Root(TreeNode node, TreeNode target){
  List<TreeNode> path = new ArrayList<>();
  while(one != target){
    path.add(one);
    one = one.parent;
  }
  return path;
}
//2) bianry tree - k node
public TreeNode LCA(TreeNode root, Set<TreeNode> nodes){
  if(root == nuoll)
    return null;
  if(nodes.contains(root))
    return root;
  TreeNode left = LCA(root.left, nodes);
  TreeNode right = LCA(root.right, nodes);
  int counter = 0;
  if(left != null && right != null)
    return root;
  return left != null ?  left : right;
}
//3) kanry tree - 2 node
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  if(root == nuoll)
    return null;
  if(root == one || root == two)
    return root;
  int counter = 0;
  TreeNode temp = null;
  for(TreeNode child : root.children){
    TreeNode node = LCA(child, one, two);
    if(node != null){
      counter++;
      if(counter > 1)
        return temp;
    }
    temp = node;
  }
  return temp;
}
//3) knary tree - knode
public TreeNode LCA(TreeNode root, Set<TreeNode> nodes){
  if(root == nuoll)
    return null;
  if(nodes.contains(root))
    return root;
  int counter = 0;
  TreeNode temp = null;
  for(TreeNode child : root.children){
    TreeNode node = LCA(child, nodes);
    if(node != null){
      counter++;
      if(counter > 1)
        return temp;
    }
    temp = node;
  }
  return temp;
}
//4) bst - 2 node
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  if(root == null)
    return null;
  if(root.key < one && root.key < two)
    return LCA(root.left, one, right);
  if(root.key > one && rootkey > two)
    return LCA(root.right, one, right);
  return root;
}
//maxPath
//reconstruct bt
public TreeNode reconstruct(int[] in, int post){
  Map<Integer,Integer> map = new HashMap<>();
  for(int i = 0; i < in.length; i++)
    map.out(in[i], i);
  return helper(in, 0, in.length-1; post, 0, post.length-1, map);
}
private TreeNode helper(int[] in, int inleft, int inright,
                        int[] post, int postleft, int postright,
                        Map<Integer, Integer> map){
  if(inleft > inright)
    return null;
  TreeNode root = new TreeNode(post[postright]);
  int left_size = map.get(root.key);
  root.left = helper(in, inleft, inleft+size-1, post, postleft, postleft+left_size-1, map);
  root.right = helper(in, inleft_size+1, post, postleft_left_size, postright-1, map);
  return root;
}
public TreeNode reconstruct(int[] in, int pre){
}
private TreeNode helper(int[] in, int inleft, int inright,
                        int[] pre, int preleft, int preright,
                        Map<Integer, Integer> map){
  if(inleft > inright)
    return null;
  TreeNode root = new TreeNode(pre[preleft]);
  int left_size = map.get(root.key);
  root.left = helper(in, inleft, inleft+size-1, pre, preleft+1, preleft+left_size, map);
  root.right = helper(in, inleft_size+1, pre, preleft_left_size+1, preright, map);
  return root;
}
public TreeNode reconstruct(int[] in, int level){
  Map<Integer,Integer> map = new HashMap<>();
  for(int i = 0; i < in.length; i++)
    map.out(in[i], i);
  List<Integer> levellist = new ArrayList<>();
  for(Integer each : level)
    levellist.add(each);
  return helper(map, level);
}
private TreeNode helper(int[] in, int inleft, int inright,
                        int[] pre, int preleft, int preright,
                        Map<Integer, Integer> map){
  if(levellist.isEmpty())
    return null;
  TreeNode root = levellist.get(0);
  List<Integer> left = new ArrayList<>();
  List<IntegeR> right= new ArrayList<>();
  for(Integer each : levellist){
    if(map.get(each) < map.get(root.key))
      left.add(each);
    else
      right.add(each);
  }
  root.left = helper(map, left);
  root.right = helper(map, right);
  return root;
}
//mathpathsum
//node to nodes
public int maxPathSum(TreeNode root){
  int[] max = new int[0]{};
  helper(root, max);
  return max[0];
}
private int helper(TreeNode root, int[] max){
  if(root = null)
    return 0;
  int left = helper(root.left, max);
  int right = helper(root.right, max);
  left = left > 0 ? left : 0;
  right = right > 0 ? right : 0;
  max[0] = Math.max(max[0], root.key + left + right);
  return root.key + Math.max(left,right);
}
//leaf to leaf
private int helper(TreeNode root, int[] max){
  if(root == null)
    return 0;
  int left = helper(root.left, max);
  int right = helper(root.right, max);
  if(left != null && right != null)
    max[0] = Math.max(max[0], root.key + left + right);
    return root.key + Math.max(left, right);
  if(left != null)
    return root.key + left;
  if(right != null)
    return root.key + right;
}
//left to root: bottom up
public int maxPathSum(TreeNode root){
  if(root.left == null && root.right == null)
    return root.key;
  if(root.left == null)
    return root.key + root.right.key;
  else if(root.right == null)
    return root.key + root.left.key;
  //both not null
  return root.key + Math.max(maxPathSum(root.left), maxPathSum(root.right));
}
//root to node  ? the helper?!
public int maxPathSum(TreeNode root){

}
//subroot to nodes (node to node)
private int heler(TreeNode root, int[] max){
  if(root == null)
    return 0;
  int left = helper(root.left, max);
  int right = helper(root.right, max);
  left = left > 0 ? left : 0;
  right = right  > 0 ? right : 0;
  max[0] = Math.max(max[0], root.key + Math.max(0, Math.max(left, right)));
  return root.key + Math.max(0, Math.max(left, right));
}
//subroot to node target
