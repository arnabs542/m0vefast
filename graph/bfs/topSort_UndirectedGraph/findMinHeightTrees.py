'''
https://leetcode.com/problems/minimum-height-trees/
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
return all such roots

用拓扑排序即可  edges like graph valid tree:  1) build map
首先我们将所有的叶子节点都放入队列中  2) enqueue with indegree = 1(leaf)
之后每次有点从队列中出来，就将和这个点相邻的没有入队过的点加入到队列中   3) maintain queue
It is easy to see that the last two pointers are from the two ends of the longest path in the graph.
'''
def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
    #0-(n-1) nodes
    # map = collecitons.defaultdict(list)
    # can be replace by set() since 0->n-1
    if n == 1:
        return [0]
    # step1: build map
    graph = [set() for _ in range(n)]
    for edge in edges:
        graph[edge[0]].add(edge[1])
        graph[edge[1]].add(edge[0])
    # step2:
    queue = collecitons.deque([leaf for leaf in range(n) if len(graph[leaf]) == 1])
    # step3:
    res = []
    while n > 2:
        size = len(queue)
        n -= size
        for _ in range(len(size))
            leaf = queue.popleft()
            inner_nei = graph[leaf].pop()
            graph[inner_nei].remove(leaf)
            if len(graph[inner_nei] == 1):
                queue.append(inner_nei)

    while queue:
        res.append(quuee.popleft())
    return res
