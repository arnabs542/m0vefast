//solution1: using hashmap to avoid copy multiple times for the same node
//O(n)
public RandomListNode copy(RandomListNode head){
	if(head == null)
		return null;
	RandomListNode dummy = new RandomListNode(0);
	dummy.next = head;
	RandomListNode cur = dummy;
1) head, next, random
2) cur, next, random
since we are doing iterative, no need to care about .next
	//original node, copied node
	Map<RandomListNode, RandomListNode> map = new HashMap<>();

	while(head != null){
		//cur node 1) checkmap, 2) copy
		if(!map.containsKey(head)){
			map.put(head, new RandomListNode(head.value));
		}
		cur.next = map.get(head);
		//random 0) valid 2) chekc map, 3) copy
		if(head.random != null){
			if(!map.containsKey(head.random)){
				map.put(head.random, new RandomListNode(head.random.value));
			}
			cur.next.random = map.get(head.random);
		}
		//iteration
		head = head.next;
		cur = cur.next;
	}
	return dummy.next;
}
//solutioin2: changing the original list structure during the copy
