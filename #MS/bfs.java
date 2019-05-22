//isBipartite\
for each node, check right group with bfs
if visited, treturn true
queue add see, pop, and chekc neighbour
for each nei, check map.group if exist, ifnot , add in map
//is complete tree
public boolean isComplete(TreeNode root){
  Queue<TreeNode> queue = new LinkedList<>();
  boolean flag = false
  //intial state
  queue.offer(root);
  while(!queue.isEmpty()){
    TreeNode cur = queue.poll();

    if(cur.left == null)
      flag = true;
    if(cur.left != null && flag)
      return false;
    if(cur.left != null && !flag)
      queue.offer(cur.left);

    if(cur.right == null)
      flag = true;
    if(cur.right != null && flag)
      return fasle;
    if(cur.right != null && !flag)
      queue.offer(cur.right);
  }
  return true;

}


//tree iterative inoder, preorder, postoreder, level order, ziazag
public List<Integer> inorder(TreeNode root){
  Stack<TreeNode> stack = new Stack<>();
  TreeNode cur = root;

  while(cur != null || !stack.isEmpty()){
    //not leftmost of current Tree
    while(cur != null){
      stack.push(cur);
      cur = cur.left;
    }
    //try other subtree
    cur = stack.pop();
    res.add(cur.value);
    cur = cur.right;
  }
  return res;
}
public List<Integer> preorder(TreeNode root){
  Stack<TreeNode> stakc =new Stack<>();
  Stack.push(root);
  //TreeNode cur = null;
  while(!stack.isEmtpy()){
      TreeNode cur = stack.pop();
      res.add(cur);
      if(cur.right !=null)
        stack.push(cur.right);
      if(cur.left != null)
        stack.push(cur.left);
  }
  return res;
}
public List<Integer> postorder(TreeNode root){
  Stack<TreeNode> stakc =new Stack<>();
  Stack.push(root);
  //TreeNode cur = null;
  while(!stack.isEmtpy()){x
      TreeNode cur = stack.pop();
      res.add(0, cur);
      if(cur.left !=null)
        stack.push(cur.left);
      if(cur.right != null)
        stack.push(cur.right);
  }
  return res;
}
public List<Integer> levelorder(TreeNode root){
  Queue<TreeNode> queue= new LinkedLisT<>();
  //initial state
  queue.offer(root);
  while(!queue.isEmpty()){
    int size = queue.size();
    for(int i = 0; i < size; i++){
      //expand
      TreENode cur = queue.poll();
      res.add(cur.value);
      //generage
      if(cur.left != null)
        queue.offer(cur.left);
      if(cur.right != null)
        queue.offer(cur.right);
    }
  }
  return res;
}
public List<Integer> zigzag(TreeNode root){
  Deque<TreeNode> deque = new LinedkList<>();
  int layer = 0;
  //intial state
  deque.offerLast(root);
  while(!deque.isEmpty()){
    int size = deque.size();
    for(int i = 0; i < size; i++){
      if (layer == 0){
        TreeNode cur = deque.pollLast();
        res.add(cur.key);
        if(cur.right !=null)
          deque.offerFirst(cur.right);
        if(cur.left != null)
          deque.offerfrist(cur.left);
      }else{
        TreeNode cur = deque.pollFirst();
        res.add(cur.key);
        if(cur.left !=null)
          deque.offerLast(cur.left);
        if(cur.right != null)
          deque.offerLast(cur.right);
      }
    }
    layer = 1 - layer;
  }
  return res;
}

//flatten
public List<Integer> flatten(TreeNode root){
  Stack<TreeNode> stack = new Stack<>();
  TreeNode cur = root;
  while(cur != null || !stack.isEmpty()){
    //save right
    if(cur.right != null)
      stack.push(cur.right);
    //process left
    if(cur.left != null){
      cur.right = cur.left;
      cur.left = null;
    }else{
      cur.right = stack.pop();
    }
    cur = cur.right;
  }
}
//clone graph, linekdlist with random pointer
public RandomListNode copy(RandomListNode head){
  if(head == null)
     return new ListNode(0);
  ListNode cur = new ListNode(0);
  Map<ListNode, ListNode> map = new HashMAp<>();
  while(head != null){
    //check head 1) in map
    if(!map.containsKey(head))
      map.put(head, new ListNode(head.value))
    cur.next = map.get(head);
    //check rnadom pointer 1) in map
    if(head.random != null){
      if(!map.containsKey(head.random))
        map.put(head.random, new ListNode(head.random.value));
      cur.next.random = map.get(head.random);
    }
    head =head.next;
    cur = cur.next;
  }
  return dummy.next;


}
public ListNode clone(List<GraphNode> graph){
  if(graph == null || graph.length == 0)
    return graph;
  Map<node, node> map
  for(GraphNode node : graph){
    if(!map.containsKey(node))
      map.put(node, new node(vlaue))
      dfs(node, map);

  }
  return new ArrayList<Node>(map.values());

}
private void dfs(seed, map){
  copy = map.geT(seed);
  for(node nei : seed.neightbour){
    if(!map.containsKey(nei))
      map.put(nei, new node())
    else
      dfs(nei, map)
  }
  copy.nei.add(map.get(nei))
}
//bst iterator


//smallest 357



//dfs: 4 +  valid paranthesis


//wrod break
public boolena wordbreak(char[][] matrix, String str){
  if(matrix == null || matrix.length == 0 || str == null || str.length() == 0)
    return false;
  for(int i = 0; i < matrix.length; i++){
    for(int j = 0; j < matrix[0].length; j++){
      if(dfs(mtrix, str, i, j, 0))
        return true;
    }
  }
  return false;
}
private boolean dfs(int[][] matrix, String str, int i, int j, int k){
  //prune
  if(!invalid(matrix, i, j))
    return fasle;
  if(matrix[i][j] != str.charAt(k))
    return false;
  //termination condition
  if(k == str.legnth()-1)
    return true;
  else{
    //visited
    char cur=matrix[i][j];
    matrix[i][j] = "#";
    if(dfs(matrix, str, i+1, j, k+1) || dfs(matrix, str, i-1, j, k+1)|| dfs(matrix, str, i, j+1, k+1) || dfs(matrix, str, i, j-1, k+1))
      return true;
    //back track unvisited
    matrix[i][j] = cur;
  }
  return false;

}

}
