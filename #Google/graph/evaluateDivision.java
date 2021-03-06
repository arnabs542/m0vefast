//https://massivealgorithms.blogspot.com/search?q=evaluate+division
//directed graph: 等式a / b = 2.0，可以转化为两条边：<a, b>，<b, a>，其长度分别为2.0，0.5
//历equations与values: E 用g数组保存有向图中各边的长度，  V 利用vset记录顶点集合
//调用Floyd算法即可  BFS
//eg: currenty converter
public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
  //<tstar_node, <end_node, edge_weight>>
  Map<String, Map<String, Double>> graph = new HashMap<>();
  for(int i = 0; i < equations.length; i++){
    addEdge(graph, equations[i][0], equations[i][1], values[i]);
    addEdge(graph, equations[i][1], equations[i][0], 1/values[i]);
  }
  double[] res = new double[queries.length];
  for(int j = 0; j < res.length; j++){
    res[i] = getValue(graph, queries[i][0], queries[i][1]);
  }
  return res;
}
//update map
private void addEdge(Map<String, Map<String, Double>> graph, String start, String end, double value){
  Map<String, Double> map;  //value: <endnotde: edge>
  if(graph.containsKey(start))
    map = graph.get(start);
  else
    map = new HashMap<>();
  map.put(end, value);
  graph.put(start, map);
}
//shortest path from start to end on a connected graph
private double getValue(Map<String, Map<String, Double>> graph, String start, String end){
  if(graph.get(start) == null || graph.get(end) == null)
    return -1;
  Queue<String> queue = new LinkedList<>();
  Set<String> visited = new HashSet<>();

  //distance from startnode
  Map<String, Double> disToStart = new HashMap<>();

  //initialization
  queue.add(start);
  visited.add(start);
  //use start as the base node start->start = 1
  //continue build graph or calculaiton
  // <node, distance to ancestor_node>
  disToStart.put(start, 1d);   //1d is the relative distance

  //expand
  while(!queue.isEmpty()){
    String cur_node = queue.poll();
    //for all possible reachbel node from startNode
    for(Map.Entry<String, Double> edge : graph.get(cur_node).entrySet()){
      String next_node = edge.getKey();
      //                           (bottom) cur-ancestor * ancestor to root (top)
      disToStart.put(next_node, disToStart.get(cur_node) * edge.getValue());
      //generation  + deduplicate
      if(next_node.equals(end)){
        return disToStart.get(end);
      //contineu build edge connections
    }else if(!visited.contains(next_node)){
        queue.offer(next_node);
        visited.add(next_node);
      }
    }
  }
  return -1;
}
