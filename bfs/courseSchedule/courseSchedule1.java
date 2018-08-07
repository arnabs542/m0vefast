https://zxi.mytechroad.com/blog/graph/leetcode-207-course-schedule/
//topological sort: directed graph, no cycle
public boolean courseSchedule1(int numCourses, int[][] prerequisites) {
    // Write your solution here
  if(prerequisites == null || prerequisites.length == 0 || numCourses == 0)
    return true;
  //counter for numebr of prerequisites, degree
  int[] counter = new int[numCourses];
  for(int i = 0; i < prerequisites.length; i++)
     //counter[target course] :  how many prerequrisites
     counter[prerequisites[i][0]]++;
  //course that has no prerequeisite
  Queue<Integer> queue = new LinkedList<>();
  for(int i = 0; i < numCourses; i++){
    if(counter[i] == 0)
      queue.add(i);
  }
  //numebr of courses that has no prequeusite
  int noPre = queue.size();
  while(!queue.isEmpty()){
    int top = queue.poll();
    for(int i = 0; i < prerequisites.length; i++){
      //if a course's prerequisite can be satisfied by a course in queue
      if(prerequrisites[i][1] == top){
        counter[prerequrisites[i][0]]--;
        if(counter[prerequrisites[i][0]] == 0){
          noPre--;
          //if a course dont has prerequeisite, then it can be a supported course for others
          queue.offer(prerequrisites[i][0]);
        }
      }
    }
  }
  return noPre == numCourses;
}
