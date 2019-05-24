def numIslands1(self, grid: List[List[str]]) -> int:
    if not grid or grid[0]:
        return 0

    islands = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] = '1':
                self.bfs(grid, i, j)
                islands += 1
    return islands

def bfs(self, grid, x, y):
    # 1) intializaiton
    # 2) expand
    # 3) generation
    # 4) duplicaton

    # 1)
    queue = deque([(x,y)])
    grid[x][y] = 'x'

    while queue:
        # 2)
        x, y = queue.popleft()
        for dx, dy in [(1,0), (0, -1), (-1, 0), (0, 1)]:
            new_x = x + dx
            new_y = y + dy
            if self.is_valid(grid, next_x, next_y):
                # 3)
                queue.append((new_x, new_y))
                # 4)
                grid[new_x][next_y] = 'x'

def is_valid(self, grid, x, y):
    return 0 <= x < len(grid) and 0 <= y <= len(grid[0]) and grid[x][y] == '1'
