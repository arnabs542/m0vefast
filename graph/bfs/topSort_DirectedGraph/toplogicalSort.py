def topologicalSort(graph):
     """
    @param graph: A list of Directed graph node
    @return: A list of integer
    """
    # step1) build map
    dict = {}
    for node in graph:
        dict[node] = len(node.neightbours)

    # maintain QUEUE bfs
    queue = collections.deque()
    #initialization
    queue.append([node for node in graph if dict[node] == 0])

    while queue:
        # expand
        cur = queue.popleft()
        res.append(cur)
        # generate
        for nei in dict[cur]:
            dict[nei] -= 1
            if dict[nei] == 0:
                queue.append(nei)
    return res
