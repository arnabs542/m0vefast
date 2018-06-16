public class Solution {
	private PriorityQueue<Integer> smallhalf;
	private PriorityQueue<Integer> largehalf;
  	public Solution() {
    // add new fields and complete the constructor if necessary.
  		smallhalf = new PriorityQueue<>(11, Collections.reverseOrder());  //maxheap
  		largehalf = new PriorityQueue<>();  //minheap
  	}

  	public void read(int value) {
    // write your implementation here.
  		if(smallhalf.isEmpty() || value <= smallhalf.peek())
  			smallhalf.offer(value);
  		else
  			largehalf.offer(value);
  		if(smallhalf.size() - largehalf.size() >= 2)
  			largehalf.offer(smallhalf.poll());
  		else if(largehalf.size() > smallhalf.size())
  			smallhalf.offer(largehalf.poll());
  	}

  	public Double median() {
    // write your implementation here.
  		int size = smallhalf.size()+largehalf.size();
  		if(size == 0)
  			return null;
  		if(size % 2 == 1)
  			return (double)smallhalf.peek();
  		else
  			return (smallhalf.peek() + largehalf.peek())/2.0;
  	}
}
