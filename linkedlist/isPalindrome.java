public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null)
        return true;
    ListNode mid = findMid(head);
    ListNode second = mid.next;
    //12345 mid is 3
    mid.next = null;
    //12345 3
    ListNode secondHead = reverse(second);

  while(head != null && secondHead != null){
    if(head.value != secondHead.value)
      return false;
    head = head.next;
    secondHead = secondHead.next;
  }
    return true;
}
//12345 3     1234  2
private ListNode findMid(ListNode head){
	ListNode slow = head;
	ListNode fast = head;
  //int len = 1;
	//make sure slow and fast is movable
	while(fast.next!= null && fast.next.next!= null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}
private ListNode reverse(ListNode head){
	if(head == null || head.next == null)
		return head;
	ListNode next = head.next;
	//ListNode newHead = reverseLinkedList(head.next);
	ListNode newHead = reverse(next);
	next.next = head;
	head.next = null;
	return newHead;
}
[[2,5,2,6,6,8,8,6,6,2,5,2]]
public boolean isPalindrome(ListNode head) {

    if(head == null || head.next==null)
        return true;

    //find list center
    ListNode fast = head;
    ListNode slow = head;

    while(fast.next!=null && fast.next.next!=null){
        fast = fast.next.next;
        slow = slow.next;
    }

    ListNode secondHead = slow.next;
    slow.next = null;

    //reverse second part of the list
    ListNode p1 = secondHead;
    ListNode p2 = p1.next;

    while(p1!=null && p2!=null){
        ListNode temp = p2.next;
        p2.next = p1;
        p1 = p2;
        p2 = temp;
    }

    secondHead.next = null;

    //compare two sublists now
    ListNode p = (p2==null?p1:p2);
    ListNode q = head;
    while(p!=null){
        if(p.val != q.val)
            return false;

        p = p.next;
        q = q.next;

    }

    return true;
}
