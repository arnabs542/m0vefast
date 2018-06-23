//recursive solution
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
//iterative solution
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
