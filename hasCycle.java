public boolean hasCycle(ListNode head){
	ListNode fast = head;
	ListNode slow = head;
	while(fast.next!= null){
	//while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
		if(slow == fast)
			return true;
	}
	return false;
}