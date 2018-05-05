public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
	//no
	PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2*k, new Comparator<List<Integer>>(){
		@Override
		public int compare(List<Integer> o1, List<Integer> o2){
			long d1 = distance(o1, a, b, c);
			long d2 = distance(o2, a, b ,c);
			if(d1 == d2)
				return 0;
			return d1 < d2 ? -1: 1;
		}
	});
	//comparing the actural elements in the list
	Set<List<Integer>> visited = new HashSet<>();
	List<Integer> cur = Arrays.asList(0,0,0);
	visited.add(cur);
	minHeap.offer(cur);

	//think of cur as an object(candidate_index_in_a, index_in_b,index_in_c)
	//got to check the length, so k > 0 not k>1
	//o1, o2, cur, temp are sme object type
	while(k > 0){
		cur = minHeap.poll();
		List<Integer> temp = Arrays.asList(cur.get(0)+1, cur.get(1), cur.get(2));
		if(temp.get(0)<a.length && visited.add(temp))
			minHeap.offer(temp);
		n = Arrays.asList(cur.get(0), cur.get(1)+1, cur.get(2));
		if(temp.get(0)<b.length && visited.add(temp))
			minHeap.offer(temp);
		n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2)+1);
		if(temp.get(0)<c.length && visited.add(temp))
			minHeap.offer(temp);
		k--;
	}
	//replace index with actual values in a,b,c
	cur.set(0, a[cur.get(0)]);
	cur.set(1, b[cur.get(1)]);
	cur.set(2, c[cur.get(2)]);
	return cur;
}
//points(index_in_a, index_in_b, index_in_c)
private long distance(List<Integer> point, int[] a, int[] b, int[] c){
	long dis = 0;
	dis += a[point.get(0)] * a[point.get(0)];
	dis += b[point.get(1)] * b[point.get(1)];
	dis += b[point.get(2)] * b[point.get(2)];
	return dis;
}
