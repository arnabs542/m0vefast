public int[] findOrder(int numCourses, int[][] prerequisites) {
    // Write your solution here
    List[] edges = new ArrayList<>();    //can support how many higher courses
    int[] degree = new int[numCourses];  //going into pCounter
    for(int i = 0; i < numCourses; i++){
      edge[i] = new ArrayList<>();
    }
    for(int i = 0; i < prerequisites.length; i++){
      degree[prerequisites[i][0]]++;
      edges[prerequisites[i][1]].add(prerequisites[i][0]);
    }
    //course that has no prerequeisite
    Queue<Integer> queue = new LinkedList();
    for(int i = 0; i < degree.length; i++){
      if(degree[i] == 0)
        queue.add(i);
    }
    int counter = 0;
    int[] order = new int[numCourses];
    while(!queue.isEmpty()){
      int course = queue.poll();
      order[counter] = course;
      counter++;
      int n = edges[course].size();
      for(int i = n-1; i >= 0; i--){
        int pointer = edges[course].get(i);
        degree[pointer]--;
        if(degree[pointer] == 0)
          queue.add(pointer);
      }
    }
}
if(counter == numCourses)
  return order;
return new int[0];
