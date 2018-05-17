//initially positioned at an arbitrary index of the array
//you can either jump left or jump right
//Determine the minimum jumps you need to reach the right end of the array.
//Return -1 if you can not reach the right end of the array.
//https://piazza.com/class/j0eqhhdregb3i?cid=2508
//bfs: O(n^2)
public int minJump(int[] array, int index) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    if (index == array.length - 1) {
    	return 0;
    }
    //http://www.baeldung.com/java-array-deque
    //here use arraydeque as a queue
    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    queue.offer(index);
    map.put(index, 0);   //index, steps to current index
    while (!queue.isEmpty()) {
    	int curr_index = queue.poll();
      int step = map.get(curr_index);
      //for each left and right distance we could reach
      for (int i = 1; i <= array[curr_index]; i++) {

      	if (curr_index + i >= array.length - 1) {
      		return step + 1; //step of curretn index + one more step from current index to the end
      	}
        //to right
      	if (curr_index + i < array.length && !map.containsKey(curr_index + i)){
        	map.put(curr_index + i, step + 1);
          queue.offer(curr_index + i);
        }
        //to left
        if (curr_index - i >= 0 && !map.containsKey(curr_index - i)){
        	map.put(curr_index - i, step + 1);
          queue.offer(curr_index - i);
        }
      }
    }
    return -1;
  }
