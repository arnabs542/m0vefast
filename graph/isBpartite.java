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
  	if(visited.containsKey(node))
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
