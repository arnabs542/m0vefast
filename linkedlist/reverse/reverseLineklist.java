public ListNode reverseLinkedList(ListNode head){
	if(head == null || head.next == null)
		return head;
	ListNode prev = null;
	while(head != null){
		ListNode next = head.next;
		//only move the pointer
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}
public ListNode reverseLinkedList(ListNode head){
	if(head == null || head.next == null)
		return head;
	ListNode next = head.next;
	//ListNode newHead = reverseLinkedList(head.next);
	ListNode newHead = reverseLinkedList(next);
	next.next = head;
	head.next = null;
	return newHead;
}
