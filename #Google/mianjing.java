//gas station
//find peak element
//number of numIsland: bfs
//isomorphic stirngs: hashmap
//group shifted strings
//meeting room: interval, queue
//range sum query 2d-mutable
//longest substring with at most k distinct chars
//logger rage limiter
//evaluate division: union find ......
//sentence screen fitting
//the maze123
//predict winner
// next greater element1, and with streaming data
//redundant connection2
//cracking the safe
//bus routes
//moving puzzle: bfs shortest path  (TODO)
https://leetcode.com/problems/sliding-puzzle/discuss/146652/Java-8ms-BFS-with-algorithm-explained
public int slidingPuzzle(int[][] board) {
  int row = board.length;
  int col = board[0].length;
  int i = 0;
  int j = 0;
  for(i = 0; i < row; i++){
    for(j = 0; j < col; j++){
      if(board[i][j] == 0){
        break;
      }
    }
  }
  int[] dx = new int[]{};
  int[] dy = new int[]{};
  Queue<Node> queue = new LinkedList<>();
  Set<String> visite d= new HashSEt<>();

  Node start = new Node(board, i, j, 0);
  queue.offer(start)
  visited.add(start)

  String target = "";

}
//OPTIMAL LIST OF JOB:
//find kth frequently number in int[]: map + pq
public int topKth(int[] arr, int k){
  if(arr == null || k <= 0){
    return -1;
  }
  Map<Integer, Integer> map = buildMap(arr);
  PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(11, new MyComparator<Map.Entry<Integer, Integer>>);

  for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    if(minHeap.size() < k){
      minHeap.offer(entry);
    }else if(minHeap.peek().getValue() < entry.getValue()){
      minHeap.poll();
      minHea.offer(entry);
    }
  }
  return minHeap.peek().getKey();
}

private Map<Integer, Integer> buildMap(int[] arr){
  Map<Integer, Integer> map = new HashMap<>();
  for(int i = 0; i < arr.length; i++){
    if(map.containskKety(arr[i])){
      map.put(arr[i], map.get(arr[i] + 1));
    }else{
      map.put(arr[i], 1);
    }
  }
  return map;

}
static class MyComparator implemetns Comparator{
  @Override
  public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Intger, Integer> e2){
    if(e1.getValue() == e2.getValue()){
      return 0;
    }
    return e1.getValue().compareTo(e2.getValue());
  }
}
//currency exchange: shrtest path: shortest path bfs: map<start, <end, relativeDistance>>
//https://www.cnblogs.com/xz816111/p/4512498.html
public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
  Map<String, Map<String, double>> graph = new HashMap<>();
  for(int i = 0; i < values.length; i++){
    buildGraph(graph, equaltions[i][0], equaltions[i][1], values[i]);
    buildGraph(graph, equaltions[i][1], equaltions[i][0], 1/values[i]);
  }
  double[] res = new double[queries.length];
  for(int j = 9; j < queries.length; j++){
    res[j] = getEdge(graph, queries[i][0], queries[i][1]);
  }
  return res;
}
private void buildGraph(Map<String, Map<String, double>> graph, String startNode, String endNode, double edge){
  Map<String, double> children;
  if(!graph.containsKey(startNode)){
    children = new HashMap<>();
  }else{
    children = graph.get(startNode);
  }
  children.put(endNode, edge);
  graph.put(startNode, children);
}
private double getEdge(Map<String, Map<String, double>> graph, String startNode, String endNode){
  if(!graph.containsKey(startNode) || !graph.contains(endNode)){
    return -1.0
  }
  //BFS: maintain
  Queue<String> queue = new LinkedList<>();
  Set<String> visited = new HashSet<>();
  Map<String, double> disToStart = new HashMap<>();

  //1) initialization
  queue.offer(startNode);
  visited.add(startNode);
  disToStart.put(startNode, 1d);

  //5) termination condition
  while(!queue.isEmpty()){
    //2) expand
    String curNode = queue.poll();
    double step = disToStart.get(curNode);
    //3) generation
    for(Map.Entry<String, double> entry : graph.get(curNode).entrySet()){
      String neiNode = entry.getKey();
      disToStart.put(neiNode, step * entry.getValue());
      if(endNode.equals(neiNode){
        return entry.getValue();
      }else{  //4) check duplication
        if(!visited.contains(neiNode)){
          visited.add(neiNode);
          queue.offer(endNode);
        }
      }
    }
  }
  return -1;
}
//range random query (TODO): using trie? next word frequency?
//unique path in matrix https://leetcode.com/problems/unique-paths/ 2 * dp
//https://www.programcreek.com/2014/05/leetcode-unique-paths-java/
//can use dfs, but very slow
//solution1: dp
public int uniquePaths(int m, int n) {
  if(m == 0 || n == 0){
    return 0;
  }
  if(m == 1 || n == 1){
    return 1;
  }
  int[][] m = new int[m][n];
  for(int i = 0; i < m; i++){
    for(int j = 0; j < n; ++){
        if(i == 0 || j == 0){
          m[i][j] = 1;
        }else{
          m[i][j] = m[i-1][j] + m[j][j-1];
        }
    }
    return m[m-1][n-1];
}
//solution2: dp + memorization
//follow up: (TODO)
//长凳做人问题 (TODO)
//PLAYER AB colouring node
//clarning robot
//https://www.cnblogs.com/lightwindy/p/9739158.html,     https://www.cnblogs.com/grandyang/p/9988250.html
//Different from regular dfs to visit all, the robot move() function need to be called,
// backtrack needs to move() manually and backtracking path shold not be blocked by visited positions
//IMPORTANT: Mark on the way in using set, but `backtrack directly without re-check against set`
//Backtrack: turn 2 times to revert, move 1 step, and turn 2 times to revert back.
int[] dx = {-1, 0, 1, 0};
int[] dy = {0, 1, 0, -1};
public void cleanRoom(Robot robot){
  //记录哪些位置已经扫过了，由于不知道全局位置，那么只能用相对位置信息了。初始时就是(0, 0)
  dfs(robot, new HashSet<>(), 0, 0, 0);
}
private void dfs(Robot robot, Set<String> visited, int x, int y, int curDir){
  String position = x + "-" + y;
  //base case? / prune
  if(visite.contains(position))
    return;
  //首先对起始位置调用clean函数，因为题目中说了起始位置是能到达的
  visited.add(position);
  robot.clean();

  for(int i = 0; i < 4; i++){
    if(robot.move()){
      dfs(robot, visited, x + dx[curDir], y + dy[curDir], curDir);
      backTrack(robot);
    }
    //turn to next xDirections, try next position  i++
    //如果用过扫地机器人的童鞋应该会有影响，当前方有障碍物的时候，机器人圆盘会先转个方向，然后再继续前进
    robot.turnRight();
    curDir += 1;
    curDir %= 4;  //4 directions
  }
}
//back to starting position (curDir)
private void backTrack(Robot robot){
  robot.turnLeft();
  robot.turnLeft();
  robot.move();
  robot.turnRight();
  robot.turnRight();
}
//TODO: is bitonic array, traverse
public boolean isBitonic(int[] arr){

  if(arr.length <= 2){
    return false;
  }
  int topIndex = -1;
  int endIndex = -1;

  for(int i = 1; i < arr.lengthl; i++){
    if(arr[i] <= arr[i-1]){
      topIndex = i;
      break;
    }
    for(int j = topIndex + 1; j < arr.length; j++){
      if(arr[j] >= arr[j - 1]){
        endIndex = j;
        break;
      }
    }
    if(endIndex != arr.lenght){
      return false;
    }
    return true;
  }
}
//logn find the largest eleemnt with biary search
public int findMax(int[] arr){
  return helper(arr, 0, arr.length);
}
private int helper(int[] arr, int left, int right){
  int mid = left + (right - left)/2;
  //base case
  if(left == right){
    return arr[left];
  }
  if(arr[mid] < arr[mid+1]){
    return helper(arr, mid+1, right);
  }else{
    return helper(arr, left, mid);
  }
}
//remove duplicate in linkedlinst keep 0
//保留0个不能葱头开始
public ListNode dupliate0(ListNode head){
  if(head == null || head.next == null)
    return head;
  ListNode dummy = new ListNode(0);
  ListNode cur = dummy;
  dummy.next = head;

  while(cur.next != null && cur.next.next! = null){
    if(cur.next.value == cur.next.next.value){
      int target = cur.next.value;
      while(cur.next != null && cur.next.value == target){
        cur = cur.next;
      }
    }else{
      cur = cur.next;
    }
  }
  return dummy.next;
}
//revmoe dplicate in linkedlist keep 1
//保留一个可以从头开始
public ListNode dupliate1(ListNode head){
  if(head == null)
    return head;
  ListNode cur = head;
  while(cur != null && cur.next != null){
    if(cur.value == cur.next.value){
      //keep the first one
      cur.next = cur.next.next;
    }else{
      cur = cur.next;
    }
  }
  return head;
}
//is power of 2   O(lgn)
public boolean isPowerOF2(int n)
{
  //base case
  if(n == 1){
    return true;
  }
  if(n > 2 && n % 2 == 0){
    return isPowerOF2(n / 2);
  }
  return false;
}
//binary tree numer of path sum to the target
//node to node in one path
//solution: O(n^2) or O(nlgn) for balanced tree;  O(n)
public int pathSum(TreeNode root, int sum) {
  if(root == null)
    return 0;
  return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
}
private int findPath(TreeNode root, int sum){
  int res = 0;
  if(root == null)
    return res;
  if(sum == root.value){
    res++;
  }
  res += findPath(root.left, sum - root.value);
  res += findPath(root.right, sum - root.value);
  return res;
}
//solution2: O(n); O(n)
public int pathSum(TreeNode root, int sum){
  Map<Integer, Integer> map = new HashMap<>();
  map.put(0, 1);   //default sum  = 0, has one count  <sum, count)
  return backTrack(root, 0, sum, map);
}
//back track one pass
private int backTrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
  if(root == null){
    return 0;
  }
  sum += root.value;
  //See if there is a subarray sum equals to target
  int res = mapgetOrDefault(sum - target, 0);
  map.put(sum, map.getOrDefault(sum, 0) + 1);
  //extend to left and right children
  res += backTrack(root.left, sum, target, map) +
          backTrack(rootright, sum, target, map);
  //Remove the current node so it wont affect other path
  map.put(sum, map.get(sum) - 1);
  return res;
}






//meeting room1
//不过要自己定义Input， 比如说 LC 上定义 Input 是 ，我定义为一个 Pair <int, int>
//写完后要求分析时间复杂度，然后给出一系列Corner Cases


//TODO:place to put chair in gym(k equipment, 1 char, some obstable)
