//solution2: DFS recursion
//O(V+E), O(V)
public List<GraphNode> copy(List<GraphNode> graph){
	if(graph == null)
		return null;
	Map<GraphNode, GraphNode> map = new HashMap<>();
	//node 1)check map, 2) dfs
	for(GraphNode node : graph){
		if(!map.containsKey(node)){
			map.put(node, new GraphNode(node.key));
			dfs(node, map);
		}
	}
	return new ArrayList<GraphNode>(map.values());
}
//for neibours: 1)check map, 2) dfs
private void dfs(GraphNode seed, Map<GraphNode, GraphNode> map){
	GraphNode copy = map.get(seed);
	for(GraphNode nei : seed.neighbours){
		if(!map.containsKey(nei)){
			map.put(nei, new GraphNode(nei.key));
			dfs(nei, map);
		}
		copy.neighbours.add(map.get(nei));
	}
}
