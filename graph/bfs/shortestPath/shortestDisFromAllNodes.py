# O(n), O(n) bfs
# similar to wallsAndGates: fill all the room (adding gate -> room to queue)
# build one house(addding all building -> houses)
def shortestDistance(self, grid: List[List[int]]) -> int:
    if grid is None or len(grid) == 0:
        return -1

    row = len(grid)
    col = len(grid[0])
    building = 0
    reachable_count = [[0 for i in range(col)] for j in range(row)]
    distance = [[0 for i in range(col)] for j in range(row)]
    res = float('inf')

    for i in range(row):
        for j in range(col):
            if grid[i][j] == 1:
                bfs(grid, i, j, reachable_count, distance)
                building += 1
    for i in range(row):
        for j in range(col):
            if reachable_count[i][j] == building and res > distance[i][j]:
                res = distance[i][j]
    return res if res != float('inf') else -1


def bfs(grid, x, y, reachable_count, distance):
    dir = [(1,0), (-1, 0), (0, 1), (0, -1)]
    queue = collections.deque([(x, y, 0)])
    visited = [False for i in range(col) for j in range(row)]
    visited[x][y] = True

    while queue:
        row, col, dist = queue.popleft()
        distance[row][col] += dist
        for k in self.dir:
            newx = row + k[0]
            newy = col + k[1]
            if isValid(grid, newx, newy) and not visited[newx][newy] and grid[newx][newy] == 0:
                queue.append((newx, newy, dis+1))
                reachable_count[newx][newy] += 1
                visited[newx][newy] = True

def isValid(grid, x, y):
    return 0 <= x < len(grid) and 0 <= y < len(grid[0])
