L = 1 -> 2 -> 3 -> null, return 2
L = 1 -> 2 -> 3 -> 4 -> null, return 2

private ListNode middleNode(ListNode head){
	ListNode slow = head;
	ListNode fast = head;
	//make sure slow and fast is movable
	while(fast.next!= null && fast.next.next!= null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}

L = 1 -> 2 -> 3 -> 4 null, return 3

private ListNode middleNode(ListNode head){
	ListNode slow = head;
	ListNode fast = head;
	//make sure slow and fast is movable
	while(fast.next!= null && fast.next.next!= null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow.next;
}
