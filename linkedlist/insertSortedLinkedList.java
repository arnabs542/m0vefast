public ListNode insert(ListNode head, int value){
	ListNode newHead = new ListNode(value);
   
	if(head == null || head.value >= value){
		newHead.next = head;
		return newHead;
	}
	ListNode cur = head;
	while(cur.next != null && cur.next.value < value){
		cur = cur.next;
	}
	newHead.next = cur.next;
	cur.next = newHead;
	return head;
}