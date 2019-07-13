# https://leetcode.com/problems/alien-dictionary/
def alienOrder(self, words: List[str]) -> str:
    # assumption: non empty list of string
    graph = build_graph(words)
    return top_sort(graph)

def build_graph(words):
    # initliaze graph
    graph = {}
    for word in words:
        for char in word:
            if char not in graph:
                graph[char] = set()

    # build edge
    for i in range(len(words) - 1):
        for j in range(min(len(words[i]), len(words[i+1]))):
            if words[i][j] != words[i+1][j]:
                graph[words[i][j]].add(words[i+1][j])
                '''
                wrf
                er
                graph[w:e]
                -> w e r(e)
                '''
                break
    return graph

def top_sort(graph):
    # 1)
    indegree = {node : 0 for node in graph}
    for node in graph:
        for nei in graph[node]:
            indegree[nei] += 1
    # 2)
    queue = collections.deque([node for node in graph if indegree[node] == 0])
    # 3)
    # detect cycle with bfs : https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/
    # If count of visited nodes/res is not equal to the number of nodes in the graph has cycle, otherwise not.

    res = ""
    while queue:
        cur = queue.popleft()
        res += cur
        for nei in graph[cur]:
            indegree[nei] -= 1
            if indegree[nei] == 0:
                queue.append(indegree[nei])

    # if all nodes popped: "z, x, z": queue will be empty if there is cycle
    if len(res) == len(graph):
        return res
    return ""
