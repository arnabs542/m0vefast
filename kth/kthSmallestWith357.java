//solution1: bfs
public long kth(int k){
	PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
	Set<Long> visited = new HashSet<>();
	//actural product value: 3^x * 5^y * 7^z to present state of <x,y,z>
	//initial state: 1,1,1	
	minHeap.offer(3*5*7L);
	visited.add(3*5*7L);
	while(k > 1){
		long cur = minHeap.poll();
		//for the state <x+1,y,z>, actual value is *3
		if(visited.add(3*cur))
			minHeap.offer(3*cur);
		//for the state <x,y+1,z>, actual value is *5
		if(visited.add(5*cur))
			minHeap.offer(5*cur);
		//for the state <x,y+1,z>, actual value is *7
		if(visited.add(7*cur))
			minHeap.offer(7*cur);
		k--;
	}
	return minHeap.peek();
}
//solution2: linear soltion using 3 deques
