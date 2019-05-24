'''
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
'''
def isBipartite(self, graph: List[List[int]]) -> bool:
    coloring = [0] * len(graph)
    # 0: not visited, colour: 1, -1
    queue = collections.deque([])
    # for each node, do dfs
    for i in range(len(graph)):
        if coloring[i] != 0:
            continue
        if not self.bfs(graph, queue, i, coloring):
            return False
    return True

def bfs(self, graph, queue, node, coloring):
    # if visited
    # if coloring[node] == 0:
    #     return True

    queue.append(node)
    coloring[node] = 0

    while queue:
        cur_node = queue.popleft()
        cur_color = coloring[cur_node]

        for nei in graph[cur_node]:
            if coloring[nei] == 0:
                queue.append(nei)
                coloring[nei] = -cur_color

            if coloring[nei] != -cur_color:
                return False
    return True
