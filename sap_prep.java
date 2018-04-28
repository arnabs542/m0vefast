//linkedlist API
class ListNode{
	int value;
	ListNode next;
	public ListNode(int value){
		this.value = value;
		this.next = null;
	}
}

public boolean isEmpty(ListNode head){
	return head == null;
}
public int getLength(ListNode head){
	int res = 0;
	if(head == null)
		return res;
	while(head != null){
		res++;
		head= head.next
	}
	return res;
}
public ListNode get(ListNode head, int index){
	if(head == null)
		return head;
	while(index > 0 && head != null){
		head = head.next;
		index--;
	}
	return head;
}
public ListNode addFirst(ListNode head, int value){
	ListNode newHead = new ListNode(value);
	newHead.next = head;
	return newHead;
}
public ListNode addLast(ListNode head, int value){
	if(head == null)
		return new ListNode(value);
	ListNode cur = head;
	while(cur.next != null){
		cur = cur.next;
	}
	cur.next = new ListNode(value);
	return head;
}
public ListNode insertSorted(ListNode head, int value){
	ListNode newNode = new ListNode(value);
	if(head == null)
		return newNode;
	ListNode cur = head;
	while(cur.next !=null && cur.next.value < value){
		cur = cur.next;
	}
	cur.next = next;
	cur.next = newNode;
	newNode.next = next;
	return head;
}

public ListNode remove(ListNode head, int value){
	if(head == null)
		return null;
	if(head.value == value)
		return head.next;
	ListNode cur = head;
	while(cur.next != null && cur.value != value){
		cur = cur.next;
	}
	//cur.next == null || cur.next.value = value
	if(cur.next != null){
		cur.next = cur.next.next;
	}
	return head;
}
//iteration
public ListNode reverse(ListNode head){
	if(head == null)
		return head;
	ListNode prev = null;
	while(head != null){
		ListNode next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}
//recursion
public ListNode reverse(ListNode head){
	if(head == null || head.next == null)
		return head;
	ListNode next = head.next;
	ListNdde newHead = reverse(next);
	next.next = head;
	head.next = null;
	return newHead;
}

public ListNode interleave(ListNode node1, ListNode node2){
	ListNode newHead = new ListNode(0);
	if(node1 != null){
		newHead.value = node1.value;
		if(node2 != null)
			newHead.next = interleave(node2, node1.next);
		else
			newHead.next = interleave(node1.next, null);
	}else{ //if node1 == null
		if(node2 != null){
			newHead.value = node2.vlaue;
			newHead.next = interleave(null, node2.next);
		}else{
			newHead = null;
		}
	}
	return newHead;
}


public ListNode insertSorted(ListNode head, int value){
	ListNode node = new ListNode(value);
	if(head == null)
		return node;
	ListNode cur = head;
	while(cur.next != null && cur.next.value < value){
		cur = cur.next;
	}
	ListNode next = cur.next;
	cur.next = node;
	node.next = next;
	return head;
}

public ListNode remove(ListNode head, int value){
	if(head == null)
		return head;
	if(head.value == value)
		return head.next;
	ListNode cur = head;
	while(cur.next != null && cur.next.val != value){
		cur = cur.next;
	}
	//cur.next = null || cur.next.val = value
	if(cur.next != null){
		cur.next = cur.next.next;
	}
	return head;
}
public ListNode interleave(ListNode list1, ListNode list2){
	ListNode neaHead = new ListNode(0);
	if(list1 != null){
		newHead.value = list1.value;
		if(list1 != null){
			newHead.next = interleave(list2, list1.next);
		}else{
			newHead.next = interleave(list1.next, null);
		}
	}else{
		if(list2 != null){
			newHead.value = list2.value;
			newHead.next = interleave(null, list2);
		}else{
			newHead = null;
		}
	}
	return null;
}
//iteration
public ListNode reverse(ListNode head){
	if(head == null) 
		return head;
	ListNode prev = null;
	while(head.next != null){
		ListNode next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}
//recursion
public ListNode reverse(ListNode head){
	if(head == null || head.next == null)
		return head;
	ListNode next = head.next;
	ListNode newHead = reverse(next);
	next.next = head;
	head.next = null;
	return newHead;
}













