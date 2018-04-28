//solution1: using hashmap to avoid copy multiple times for the same node
//O(n)
public RandomListNode copy(RandomListNode head){
	if(head == null)
		return null;
	RandomListNode dummy = new RandomListNode(0);
	dummy.next = head;
	RandomListNode cur = dummy;
	//original node, copied node
	Map<RandomListNode, RandomListNode> map = new HashMap<>();
	while(head != null){
		//copy the current node if necessary
		if(!map.containsKey(head)){
			map.put(head, new RandomListNode(head.value));
		}
		//connect copied node to the copied list
		cur.next = map.get(head);
		//copy the random node if necessary
		if(head.random != null){
			if(!map.containsKey(head.random)){
				map.put(head.random, new RandomListNode(head.random.value));
			}
			//connect the copied node to the random pointer
			cur.next.random = map.get(head.random);
		}
		head = head.next;
		cur = cur.next;
	}
	return dummy.next;
}
//solutioin2: changing the original list structure during the copy
