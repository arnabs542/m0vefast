//https://www.cnblogs.com/lightwindy/p/9739158.html
//https://www.cnblogs.com/grandyang/p/9988250.html
//Different from regular dfs to visit all, the robot move() function need to be called, backtrack needs to move() manually and backtracking path shold not be blocked by visited positions
//IMPORTANT: Mark on the way in using set, but `backtrack directly without re-check against set`
//Backtrack: turn 2 times to revert, move 1 step, and turn 2 times to revert back.
int[] dx = {-1, 0, 1, 0};
int[] dy = {0, 1, 0, -1};
public void cleanRoom(Robot robot){
  //记录哪些位置已经扫过了，由于不知道全局位置，那么只能用相对位置信息了。初始时就是(0, 0)
  dfs(robot, new HashSet<>(), 0, 0, 0);
}
private void dfs(Robot robot, Set<String> visited, int x, int y, int curDir){
  String position = x + "-" + y;
  //base case? / prune
  if(visite.contains(position))
    return;
  //首先对起始位置调用clean函数，因为题目中说了起始位置是能到达的
  visited.add(position);
  robot.clean();

  for(int i = 0; i < 4; i++){
    if(robot.move()){
      dfs(robot, visited, x + dx[curDir], y + dy[curDir], curDir);
      backTrack(robot);
    }
    //turn to next xDirections, try next position  i++
    //如果用过扫地机器人的童鞋应该会有影响，当前方有障碍物的时候，机器人圆盘会先转个方向，然后再继续前进
    robot.turnRight();
    curDir += 1;
    curDir %= 4;  //4 directions
  }
}
//back to starting position (curDir)
private void backTrack(Robot robot){
  robot.turnLeft();
  robot.turnLeft();
  robot.move();
  robot.turnRight();
  robot.turnRight();
}
