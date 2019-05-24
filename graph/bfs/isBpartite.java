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

//public boolean isBipartite(int[][] graph) {}
//输入数组中的graph[i]，表示顶点i所有相邻的顶点
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
  	//map to record which group the node belongs to(0 or 1)
    Map<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    for(GraphNode node : graph){
    	//use bfs to cur level is conflict with the neighbors level in group number
    	if(!bfs(node, visited))
    		return false;
    }
    return true;
  }
   //use bfs to cur level is conflict with the neighbors level in group number
  private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited){
    //caller processed this node before
    //otherwise, current node will be assigned to 0 again, which might have conflict 
  	if(visited.containsKey(node))
  		return true;
    //not visited this node before
  	Queue<GraphNode> queue = new LinkedList<>();
  	queue.offer(node);
  	visited.put(node, 0);  //random assigne to group0

  	while(!queue.isEmpty()){
  		GraphNode cur = queue.poll();
  		int curGroup = visited.get(cur);
  		//int neiGroup = curGroup == 0? 1 : 0;
      int neiGroup = 1 - curGroup;
      //for each of it children
  		for(GraphNode nei : cur.neighbors){
        //order matter here! since a node might have not assign and added here
  			if(!visited.containsKey(nei)){
  				visited.put(nei, neiGroup);
  				queue.offer(nei);
        //met, check which group
        }else{
          if(visited.get(nei) != neiGroup){
            return false;
          }
          //}else{ met, but different group, okay, the final return
          //  return true;
          //}
        }
  		}
  		return true;
  	}
}
