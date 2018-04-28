public ListNode findMiddle(ListNode head){
	if(head == null)
		return null;
	ListNode slow = head;
	ListNode fast = head;
	// check one element   && check two or more element
	while(fast.next != null && fast.next.next!= null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}

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
	ListNode newHead = reverseLinkedList(next);
	next.next = head;
	head.next = null;
	return newHead;
}
