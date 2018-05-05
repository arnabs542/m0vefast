public int[] merge(int[][] arrOfArrs){
	//each individual arr is not null, input is not null
	PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
	int length = 0;
	//constructing k pointers
	for(int i = 0; i < arrOfArrs.length; i++){
		int[] arr = arrOfArrs[i];
		length += arr.length;
		if(arr.length != 0){
			minHeap.offer(new Entry(i, 0, arr[0]));
		}
	}
	int[] res = new int[length];
	int cur = 0;
	while(!minHeap.isEmpty()){
		//poll()
		Entry temp = minHeap.poll();
		res[cur++] = temp.value;
		//offer()
		if(temp.y + 1 < arrOfArrs[temp.x].length){
			temp.y++;
			temp.value = arrOfArrs[temp.x][temp.y];
			minHeap.offer(temp);
		}
	}
	return res;
}
static class MyComparator implements Comparator<Entry>{
	@Override
	public int compare(Entry e1, Entry e2){
		if(e1.value == e2.value)
			return 0;
		return e1.value < e2.value? -1 : 1;
	}
}
static class Entry{
	int x; //row id, which arr
	int y; //col id, index of arr
	int value;   //value of arr[index]
	Entry(int x, int y, int value){
		this.x = x;
		this.y = y;
		this.value = value;
	}
}

/// another way using Comparator
//solution1: k size max heap
public int[] kSmallest(int[] arr, int k) {
    if(arr.length == 0 || k == 0)
    	return new int[0];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
    	@Override
    	public int compare(Integer o1, Integer o2){
    		if(o1.equals(o2))
    			return 0;
    		return o1 > o2? -1 : 1;
    	}
    });
    for(int i = 0; i < arr.legnth; i++){
    	if(i < k)
    		maxHeap.offer(arr[i]);
    	else if(array[i] < maxHeap.peek()){
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
