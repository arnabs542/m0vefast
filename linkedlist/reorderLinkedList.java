//L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
//L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
public ListNode reorder(ListNode head){
	if(head == null || head.next == null)
		return head;
	//1) find the middle node
	ListNode mid = middleNode(head);
	ListNode one = head;
	ListNode two = mid.next;
	//de-link the second half from te 2nd half
	mid.next = null;
	//2) reverse the 2nd half
	//3) merget the 2 halfs
	return interleave(one, reverse(two));
}
private ListNode middleNode(ListNode head){
	ListNode slow = head;
	ListNode fast = head;
	while(fast.next!= null&&fast.next.next!= null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}
private ListNode reverse(ListNode head){
 	if(head == null || head.next == null)
 		return head;
 	ListNode prev = null;
 	while(head != null){
 		ListNode next = head.next;
 		head.next = prev;
 		prev = head;
 		head = next;
 	}
 	return prev;
}
private ListNode interleave(ListNode one, ListNode two){
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	while(one != null && two != null){
		cur.next = one;
		one = one.next;
		cur.next.next = two;
		two = two.next;
		cur = cur.next.next;
	}
	if(one != null)
		cur.next = one;
	else
		cur.next = two;
	return dummy.next;
}
