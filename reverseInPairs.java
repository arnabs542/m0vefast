//solution1: recursion
public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    if(head == null || head.next == null)
    	return head;
    ListNode newHead = head.next;
    head.next = reverseInPairs(head.next.next);
    newHead.next = head;
    return newHead;
}
//solution2: iteration
public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while(cur.next != null && cur.next.next != null){
    	ListNode next = cur.next.next;  //=> 2 newhead
    	cur.next = cur.next.next.next;  //<= 2.next = 1
    	next.next = next; //=> 0.next = 3
    	cur = cur.next.next;  //move
    }
    return dummy.next;
}
