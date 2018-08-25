public ListNode mergeSort(ListNode head) {
    //corner case
    if (head == null || head.next == null) {
        return head;
    }

    //find middle node and divide into two list
    ListNode mid = findMid(head);
    ListNode l = head;
    ListNode r = mid.next;
    mid.next = null;

    //go into the mergeSort
    ListNode h1 = mergeSort(l);
    ListNode h2 = mergeSort(r);
    ListNode result = merge(h1, h2);
    return result;
}
private ListNode findMid(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    //if 6 elemenet, 123456   if 5 elements, 12345
    //                 s f                     s f
    while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

public ListNode merge(ListNode one, ListNode two){
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	while(one != null && two != null){
		if(one.value <= two.value){
			cur.next = one;
			one = one.next;
		}else{
			cur.next = two;
			two = two.next;
		}
		cur = cur.next;
	}
	//lin the remaining possible nodes
	if(one != null)
		cur.next = one;
	else
		cur.next = two;
	return dummy.next;
}
//O(n) time,  O(n) for call stack, recursion not good as iterative
public ListNode merge(ListNode node1, ListNode node2){
	if(node1 == null)
		return node2;
	if(node2 == null)
		return node1;
	if(node1.val <= node2.val){
		node1.next = merge(node1.next, node2);
		return node1;
	}else{
		node2.next = merge(node1, node2.next);
		return node2;
	}
}
