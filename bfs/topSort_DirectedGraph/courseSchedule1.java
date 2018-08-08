https://zxi.mytechroad.com/blog/graph/leetcode-207-course-schedule/
//BFS方法做topological sort……大概就是建图，算入度，每次移除入度为0的点直到无点可移除……一起被移除的点等级都一样…
//topological sort: directed graph, no cycle
public boolean courseSchedule1(int numCourses, int[][] prerequisites) {
    // Write your solution here
  if(prerequisites == null || prerequisites.length == 0 || numCourses == 0)
    return true;
  //build graph: hashmap<node,indegree counter>
  int[] counter = new int[numCourses];
  for(int i = 0; i < prerequisites.length; i++)
     counter[prerequisites[i][0]]++;
  //queue: node with no indegree
  Queue<Integer> queue = new LinkedList<>();
  for(int i = 0; i < numCourses; i++){
    if(counter[i] == 0)
      queue.add(i);
  }
  //remove node with indegree==0
  int canTakeCourses = 0;  //course with no-indegree(prerequisit)
  while(!queue.isEmpty()){
    int top = queue.poll();
    canTakeCourses++;
    for(int i = 0; i < prerequisites.length; i++){
      //if a course's prerequisite can be satisfied by a course in queue
      if(prerequrisites[i][1] == top){
        counter[prerequrisites[i][0]]--;
        if(counter[prerequrisites[i][0]] == 0){
          //if a course dont has prerequeisite, then it can be a supported course for others
          queue.offer(prerequrisites[i][0]);
        }
      }
    }
  }
  return canTakeCourses == numCourses;
}

//(root)pre-prerequisite ->
//high level course
