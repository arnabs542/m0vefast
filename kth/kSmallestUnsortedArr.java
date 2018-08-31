//solution1: k size max heap
public int[] kSmallest(int[] arr, int k) {
    if(arr.length == 0 || k == 0)
    	return new int[0];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
    //smallhalf = new PriorityQueue<>(11, Collections.reverseOrder());  //maxheap
    	@Override
    	public int compare(Integer o1, Integer o2){
    		if(o1.equals(o2))
    			return 0;
    		return o1 > o2? -1 : 1;
    	}
    });
    for(int i = 0; i < arr.length; i++){
    	if(i < k)     //O(k)
    		maxHeap.offer(arr[i]);
    	else if(array[i] < maxHeap.peek()){    //O(k)+O((n-k)lgk)
    		maxHeap.poll();
    		maxHeap.offer(arr[i]);
    	}
    }
    int res = new int[k];
    for(int i = k-1; i>=0; i--)
    	res[i] = maxHeap.poll();
    return res;
 }

 queue: poll(), offer(), peek(), isEmpty()
 stack: remove(), add(), peek(), empty()
//solution2: k size minheap
//solution3: average O(n)  quickselect
