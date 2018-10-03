/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
  	//map to record which group the node belongs to(0 or 1)
    Map<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    for(GraphNode node : graph){
    	//use bfs to check it all nodes are connected
    	if(!bfs(node, visited))
    		return false;
    }
    return true;
  }
  private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited){
  	if(visited.containsKey(node))  //has been coloured, so skip 
  		return true;
  	Queue<GraphNode> queue = new LinkedList<>();
  	queue.offer(node);
  	visited.put(node, 0);  //random assigne to group0

  	while(!queue.isEmpty()){
  		GraphNode cur = queue.poll();
  		int curGroup = visited.get(cur);
  		//cur.nei.group should be different from cur
  		int neiGroup = curGroup == 0? 1 : 0;
      //for each of it children
  		for(GraphNode nei : cur.neighbors){
        //assign different colour if not seen,
        // order matter here! since a node might have not assign and added here
  			if(!visited.containsKey(nei)){
  				visited.put(nei, neiGroup);
  				queue.offer(nei);
        //met, but same group
  			}else if(visited.get(nei) != neiGroup)
  				return false;
        //met, but different group, okay, the final return
  		}
  		return true;
  	}
}

http://www.cnblogs.com/grandyang/p/8519566.html
[[1,2,3], [0,2], [0,1,3], [0,2]]     node 0 is connected to 123, node 1 is connected to 02
public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)
            return true;
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i < graph.length; i++)
        {
            if(!bfs(visited, graph, i)){
                return false;
            }
        }
        return true;

    }
    private boolean bfs(Map<Integer, Integer> visited, int[][] graph, int i){

        if(visited.containsKey(i))
           {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited.put(i, 0);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int cur_group = visited.get(cur);
            int nei_group = 1 - cur_group;
            for(int nei : graph[cur]){
                if(!visited.containsKey(nei)){
                    visited.put(nei, nei_group);
                    queue.offer(nei);
                }else{
                    if(visited.get(nei) != nei_group){
                        return false;
                    }
                }
            }

        }
        return true;
    }
