public ListNode insert(ListNode head, int val){
	//base case
	if(head == null || val < head.val){
		ListNode newHead = new ListNode(val);
		//subproblem
		newHead.next = head;
		return newHead;
	}
	//recursion rule: 怎样用子问题解构造大问题解
	head.next = insert(head.next, value);
	return head;
}