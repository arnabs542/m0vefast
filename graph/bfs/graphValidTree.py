'''
a graph is a valid tree if
2) all connected: -> for each node in bfs, should only return
1) no cycle: -> #nodes = #edge + 1

steps
1) build graph
2) bfs on each node of graph
'''
# 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点),
# 写一个函数去判断这张｀无向｀图是否是一棵树
# @param {int} n an integer
# @param {int[][]} edges a list of undirected edges
# @return {boolean} true if it's a valid tree, or false
def graph_valid_tree(self, n, edges):
    # check not cycle
    if n - 1 != len(edges):
        return False
    # check all connected
    # 2.1 build graph
    neightbours = collections.defaultdict(list)  # dictionalry like object with value is a list
    for u, v in edges:
        neightbours[u].append(v)
        neightbours[v].append(u)
    # 2.2 To detect isolated component, we can use BFS:
    # We just start from any node and delete every node we meet during the BFS.
    # If there is any node left, then there is an isolated component.
    from collections import deque
    '''
    from queue import Queue
    queue = Queue()
    queue.get()
    queue.put(e)
    =======
    from collections import deque
    queue = deque([])
    queue.append(0)
    queue = deque([0])
    queue.popleft()
    '''
    queue = deque([0])
    visited = {}
    visited[0] = True

    while queue:
        cur = queue.popleft()
        # visited[cur] = True   #visited

        for node in neightbours(cur):
            if node not in visited:
                queue.append(node)
                visited[cur] = True

    return len(visited) == n





'''
>>> s = [('yellow', 1), ('blue', 2), ('yellow', 3), ('blue', 4), ('red', 1)]
>>> d = defaultdict(list)
>>> for k, v in s:
...     d[k].append(v)
...
>>> d.items()
[('blue', [2, 4]), ('red', [1]), ('yellow', [1, 3])]
'''
