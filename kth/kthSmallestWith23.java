// the smallest is 1 = 2^0 * 3*0
// the 2nd smallest is 2 = 2^1 * 3*0
// the 3rd smallest is 3 = 2^0 * 3*1
// the 5th smallest is 2 3 = 6 = 2^1 * 3*1
// the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8 = 2^3 * 3^0
public int kth(int k) {
    // Write your solution here
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    Set<Integer> visited = new HashSet<>();

    minHeap.offer(1);
    visited.add(1);

    while(k>1){
    	int cur = minHeap.poll();
      if(visited.add(cur*2)){
      	minHeap.offer(cur*2);
      }
      if(visited.add(cur*3)){
      	minHeap.offer(cur*3);
      }

      k--;
    }
    return minHeap.peek();
  }
