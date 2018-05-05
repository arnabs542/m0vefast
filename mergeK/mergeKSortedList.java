public ListNode merge(List<ListNode> listOfLists){
	PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new MyComparator());
	ListNode dummy = new ListNode(0);
	//dummy.next = listOfLists
	ListNode cur = dummy;
	for(ListNode node : listOfLists){
		if(node != null)
			minHeap.offer(node);
	}
	while(!minHeap.isEmpty()){
		cur.next = minHeap.poll();
		if(cur.next.next != null){
			minHeap.offer(cur.next.next);
		}
		cur = cur.next;
	}
	return dummy.next;
}
static class MyComparator implements Comparator<ListNode>{
	@Override
	public int compare(ListNode l1, ListNode l2){
		if(l1.value == l2.value)
			return 0;
		return l1.value < l2.value? -1; 1;
	}
	// static class ListNode{
	// 	int value;
	// 	public ListNode(int value){
	// 		this.value = value;
	// 	}
	// }
}
