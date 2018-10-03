public int[] findOrder(int numCourses, int[][] prerequisites) {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int len = prerequisites.length;
  int[] res = new int[numCourses];

  if(len == 0){
    for(int i = 0; i < numCourses; i++)
      res[i] = i;
    return res;
  }
  //build graph: hashmap<node,indegree counter>
  int[] counter = new int[numCourses];
  for(int i = 0; i < prerequisites.length; i++)
     counter[prerequisites[i][0]]++;

  //maintain queue
  Queue<Integer> queue = new LinkedList<>();
  for(int i = 0; i < numCourses; i++){
    if(counter[i] == 0)
      queue.add(i);
  }
  //remove node with indegree==0
  int index = 0;
  int canTakeCourses = 0;  //course with no-indegree(prerequisit)
  while(!queue.isEmpty()){
    int top = queue.poll();
    canTakeCourses++;
    res[index++] = top;
    for(int i = 0; i < prerequisites.length; i++){
      //if a course's prerequisite can be satisfied by a course in queue
      if(prerequisites[i][1] == top){
        counter[prerequisites[i][0]]--;
        if(counter[prerequisites[i][0]] == 0){
          //if a course dont has prerequeisite, then it can be a supported course for others
          queue.offer(prerequisites[i][0]);
        }
      }
    }
  }
  if(canTakeCourses == numCourses)
    return res;
  else
    return new int[0];
  }
}
