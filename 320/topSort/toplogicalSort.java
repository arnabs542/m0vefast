//find find any topological order for the given directed graph: level order
//以往拓扑排序怎么用呢？一般是用在有向图中，即A的neighbor/outdegree 中有B、则B的neighbor中就不会有A。因此统计入度的时候，入度为0的就丢进queue中；
//BFS方法做topological sort……大概就是
1)建图，算入度, maintain queue 
2)每次移除入度为0的点直到无点可移除(add to result)……一起被移除的点等级都一样…
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;  indegree
 *     DirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<DirectedGraphNode>();
        }
 * };
 */
public List<GraphNode> topSort(List<GraphNode> graph){
  List<GraphNode> res = new ArrayList<>();
  Map<GraphNode, Integer> map = new HashMap<>();
  //build graph <node, indegree counter>
  for(GraphNode node : graph){
    for(GraphNode nei : node.neightbors){
      if(map.containsKey(nei))
        map.put(nei, map.get(nei)+1);
      else
        map.put(nei, 1);
    }
  }
  //maintain the current root(s)(node with no degree/prerequisit)
  Queue<GraphNode> queue = new LinkedList<>();
  for(GraphNode node : graph){
    if(!map.containsKey(node)){
      res.add(node);   //the current root(s)
      queue.offer(node); //the current root(s)
    }
  }
  //remove node with indegree==0
  while(!queue.isEmpty()){
    GraphNode cur = queue.poll();
    for(GraphNode nei : cur.neightbors){
      map.put(nei, map.get(nei)-1);
      if(map.get(nei) == 0){
        res.add(nei);
        queue.offer(nei);
      }
    }
  }
  return res;
}
