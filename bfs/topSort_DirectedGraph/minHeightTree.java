//undirected graph, return rootnodes that form tree with minimal height
//以往拓扑排序怎么用呢？一般是用在有向图中，即A的neighbor/outdegree 中有B、则B的neighbor中就不会有A。
//因此统计入度的时候，入度为0的就丢进queue中；

//无向图 [0,1] not like 1 as the prerequisit of 0，意味着A的neighbor中有B、B的neighbor中有A，所以一开始是不会出现入度为0的情况的（除非edges为空）。
//因此我们每次找入度为1的点并且把它丢进queue中，直到没有什么可入queue的，那么最后一批queue中的点即为answer
//n nodes: from 0 - n-1, approach: remove from leave(pre-requeisite) to root
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
  List<Integer> res = new ArrayList<>();
  if(n == 0)
    return res;
  if(n == 1){
    res.add(0);
    return res;
  }

  //build graph
  List<Set<Integer>> graph = new ArrayList<>();
  for(int i = 0; i < n; i++){
    graph.add(new HashSet<Integer>());
  }
  for(int[] edge : edges){ //indegree as one for both direction
    graph.get(edge[0]).add(edge[1]);
    graph.get(edge[1]).add(edge[0]);
  }
  //maintain the current root(s)(node with no degree/prerequisit)
  Queue<Integer> queue = new LinkedList<>();  //queue is leaves
  for(int i = 0; i < n; i++){
    if(graph.get(i).size() == 1)  //not 0 for this
      queue.offer(i);
  }
  //remove node with indegree==1 for undirected graph
  while(n > 2){  //stop when n <= 2
    int size = queue.size();
    n = n - size;
    for(int i = 0; i < size; i++){
      int leaf = queue.poll();
      int subroot = graph.get(leaf);
      graph.get(subroot).remove(leaf);
      if(graph.get(neighbor).size()==1){
          queue.offer(neighbor);
      }
    }
  }
  while(!queue.isEmpty()){
    res.add(queue.poll());
  }
  return res;
  }





//https://www.jiuzhang.com/solution/minimum-height-trees/
