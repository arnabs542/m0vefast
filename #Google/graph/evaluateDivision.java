//https://massivealgorithms.blogspot.com/search?q=evaluate+division
//directed graph: 等式a / b = 2.0，可以转化为两条边：<a, b>，<b, a>，其长度分别为2.0，0.5
//历equations与values: E 用g数组保存有向图中各边的长度，  V 利用vset记录顶点集合
//调用Floyd算法即可  BFS
public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
  //<tstar_node, <end_node, edge>>
  Map<String, Map<String, Double>> graph = new HashMAp<>();
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
  Map<String, Double> map;  //node, edge
  if(graph.containsKey(start))
    map = graph.get(start);
  else
    map = new HashMap<>();
  map.put(end, value);
  graph.put(start, map);
}
private double getValue(Map<String, Map<String, Double>> graph, String start, String end){
  if(graph.get(start) == null || graph.get(end) == null)
    return -1;
  Queue<String> queue = new LinkedList<>();
  //distance from startnode
  Map<String, Double> value = new HashMap<>();
  Set<String> visited = new HashSet<>();

  //initialization
  queue.add(start);
  set.add(start);
  //use start as the base node start->start = 1
  //continue build graph or calculaiton
  // <node, distance to ancestor_node>
  disToAncestor.put(start, 1d);

  //expand
  while(!queue.isEmpty()){
    String cur_node = queue.poll();
    for(Map.Entry<String, Double> edge : graph.get(cur_node).entrySet()){
      String next_node = edge.getKey();
      //                           (bottom) cur-ancestor * ancestor to root (top)
      disToAncestor.put(next_node, disToAncestor.get(cur_node) * edge.getValue());
      //generation  + deduplicate
      if(next_node.equals(end)){
        return disToAncestor.get(end);
      //contineu build edge connections
      }else if(disToAncestor.add(next_node)){
        queue.offer(next_node);
      }
    }
  }
  return -1;
}
