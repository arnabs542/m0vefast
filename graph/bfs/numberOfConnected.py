def countComponents(self, n: int, edges: List[List[int]]) -> int:

        neighbours = collections.defaultdict(list)
        for u, v in edges:
            neighbours[v].append(u)
            neighbours[u].append(v)
        queue = collections.deque([])
        visited = {}
        res = 0
        for node in range(n):
            if node not in visited:
                self.bfs(neighbours, queue, visited, node)
                res += 1

        return res

def bfs(self, neightbours, queue, visited, node):

    queue.append(node)
    visited[node] = True

    while queue:
        cur = queue.popleft()
        for node in neightbours[cur]:
            if node not in visited:
                queue.append(node)
                visited[node] = True
