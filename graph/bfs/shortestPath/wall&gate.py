'''
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

bfs: 一开始将所有的门push到队列中，然后bfs遍历整张图即可。
'''
def wallsAndGates(self, rooms: List[List[int]]) -> None:
    # push all door(targt) to queue
    queue = collections.deque()
    for i in range(len(rooms)):
        for j in range(len(rooms[0])):
            if rooms[i][j] == 0:
                queue.append((i,j))


    # do bfs on queue each door and nei(nearest empty room)
    while queue:
        i, j = queue.popleft()
        for k in [(1,0), (-1,0), (0, 1), (0, -1)]:
            newx, newy = i+k[0], j+k[1]
            if self.isValid(rooms, newx, newy) and rooms[newx][newy] >= rooms[i][j] + 1:  # can not be -1
                rooms[newx][newy] = rooms[i][j] + 1
                queue.append((newx, newy))


def isValid(self, board, x, y):
    return 0 <= x < len(board) and 0 <= y < len(board[0])
