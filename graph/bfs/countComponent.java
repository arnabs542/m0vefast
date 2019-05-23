//Number of Connected Components in Undirected Graph
//https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
//https://github.com/awangdev/LintCode/blob/master/Java/Find%20the%20Connected%20Component%20in%20the%20Undirected%20Graph.java
//Number of Connected Components in Undirected Graph
https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
https://www.jiuzhang.com/solution/number-of-connected-components-in-an-undirected-graph/
Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not.
undirected graph with self loop:https://www.geeksforgeeks.org/?p=18516
undirected graph with no self loop: https://www.geeksforgeeks.org/union-find/
Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.
Union: Join two subsets into a single subset.

private int[] father = new int[n];
private int set;

public int countComponents(int n, int[][] edges) {
    // Write your solution here
    set = n;
    for(int i = 0; i < n; i++){
      father[i] = i;  //initial father as number itself
    }
    for(int[] each : edges){
      union(each[0], each[1]);
    }
    return set;
  }
private void union(int[] father, int a, int b){
  int root_a = find(father, a);
  int root_b = find(father, b);
  if(root_a != root_b){
    father[root_b] = root_a;
    set--;
  }
}
private int find(int[] father, int x){
  if(x == father[x])
    return x;
  return find(father, father[x]);
}



#### BFS
- BFS遍历，把每个node的neighbor都加进来.
- 一定注意要把visit过的node Mark一下。因为curr node也会是别人的neighbor，会无限循环。
- Component的定义：所有Component内的node必须被串联起来via path (反正这里是undirected, 只要链接上就好)
- 这道题：其实component在input里面都已经给好了，所有能一口气visit到的，全部加进queue里面，他们就是一个component里面的了。
- 而我们这里不需要判断他们是不是Component
Try to use ae map<Integer, false> to mark the nodes. Then do a BFS with queue
1. Mark each node in map.
2. BFS each node
3. Whenver one node is checked, mark it check

public int countComponents(int n, int[][] edges) {
    // Write your solution here





  }
  /**
   * Definition for Undirected graph.
   * class UndirectedGraphNode {
   *     int label;
   *     ArrayList<UndirectedGraphNode> neighbors;
   *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
   * };
   */
  public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
          List<List<Integer>> rst = new ArrayList<List<Integer>>();
          if (nodes == null || nodes.size() == 0) {
              return rst;
          }

          HashMap<Integer, Boolean> map = new HashMap<>();
          for (UndirectedGraphNode node : nodes) {
              map.put(node.label, false);
          }

          for (UndirectedGraphNode node : nodes) {
              if (!map.get(node.label)) {
                  bfs(rst, node, map);
              }
          }
          return rst;
      }

      public void bfs(List<List<Integer>> rst, UndirectedGraphNode node, HashMap<Integer, Boolean> map) {
          Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
          List<Integer> list = new ArrayList<Integer>();
          queue.add(node);
          map.put(node.label, true);
          UndirectedGraphNode temp;
          while (!queue.isEmpty()) {
               temp = queue.poll();
               list.add(temp.label);
               for (UndirectedGraphNode neighbor : temp.neighbors) {
                  if (!map.get(neighbor.label)) {
                      queue.offer(neighbor);
                      map.put(neighbor.label, true);
                  }
               }
          }
          Collections.sort(list);
          rst.add(list);
      }
  }
