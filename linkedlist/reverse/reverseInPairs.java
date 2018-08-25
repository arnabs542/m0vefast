//solution2: iteration
public ListNode reverseInPairs(ListNode head) {
   // Write your solution here.
   ListNode dummy = new ListNode(0);
   dummy.next = head;
   ListNode cur = dummy;
   //old and even element case
   while(cur.next != null && cur.next.next != null){ //2-1-3-4-5   0123
     swap(cur);  //swap node1 and node2 (2-1)
     cur = cur.next.next;  //move to next pair' prev
     if(cur.next == null){
       break;
   }
 }
   return dummy.next;
}

private void swap(ListNode cur){
   ListNode node1 = cur.next;
   ListNode node2 = node1.next;
   ListNode node3 = node2.next;
 //1. remove node1 from list
   cur.next = node2;
 //2. insert node1 after node2
   node2.next = node1;
   node1.next = node3;
}
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
//iteration
public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while(cur.next != null && cur.next.next != null){
    	ListNode next = cur.next.next;  //=> 2 newhead
    	cur.next.next = cur.next.next.next;  //<= 2.next = 1
    	next.next = cur.next; //=> 0.next = 3
      cur.next = next;
    	cur = cur.next.next;  //move
    }
    return dummy.next;
}
1->2->3->4->5
2->1->4->3-
