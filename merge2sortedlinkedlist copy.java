public ListNode merge(ListNode node1, ListNode node1){
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	while(node1 != null && node2 != null){
		if(node1.val <= node2.val){
			cur.next = node1;
			node1 = node1.next;
		}else{
			cur.next = node2;
			node2 = node2.next;
		}
	}
	if(node1 != null)
		cur.next = node1;
	if(node2 != null){
		cur.next = node2;
	}
	return dummy.next;
}
//O(n) time,  O(n) for call stack, recursion not good as iterative
public ListNode merge(ListNode node1, ListNode node2){
	if(node1 == null)
		return node2;
	if(node2 == null)
		return node1;
	if(node1.val <= node2.val){
		node1.next = merge(node1.next, node2);
		return node1;
	}else{
		node2.next = merge(node1, node2.next);
		return node2;
	}
}

