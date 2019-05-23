//fill empty roowm tih nearest gate or wall
//bfs: O(nm) O(n)
public int[][] wallsAndGates(int[][] room) {
    if(room.length == 0 || room[0].length == 0)
      return room;
		int n = room.length;
		int m = room[0].length;
		for(int i=0; i<room.length; i++){
			for(int j=0;j<room[0].length; j++){
				if(room[i][j] == 0){
          bfs(room, i, j);
				}
			}
		}
    return room;
  }
  private void bfs(int[][] room, int i, int j){
    Queue<Pair> queue = new LinkedList<Pair>();  //all possible path except wall
    queue.offer(new Pair(i, j));
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
		while(!queue.isEmpty()){
			Pair pos = queue.poll();
			for(int k = 0; k < 4; k++){
        Pair next = new Pair(pos.x + dx[k], pos.y + dy[k]);
        //                        NOT wall and has shorter distance
        if(inBound(next, room) && room[next.x][next.y] > room[pos.x][pos.y]+1){
          room[next.x][next.y] = room[pos.x][pos.y]+1;
				  queue.offer(next);
        }
			}
		}
}
  private boolean inBound(Pair coor, int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
}

最先找到gate，然后以gate为root进行BFS遍历，叶子节点为四个方向。
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

3  -1   0   1
2   2   1  -1
1  -1   2  -1
0  -1   3   4
