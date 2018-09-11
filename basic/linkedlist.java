//insert value
public ListNode insert(ListNode head, int value) {
  // write your solution here
  ListNode newNode = new ListNode(value);
  if(head == null || head.value > value){
    newNode.next = head;
    return newNode;
  }
  ListNode cur = head;
  while(cur.next != null && cur.next.value < value){
    cur = cur.next;
  }
  newNode.next = cur.next;
  cur.next = newNode;
  return head;
}
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
//insert at index
public ListNode insert(ListNode head, int index, int target){
  ListNode node = new ListNode(target);
  if(head == null && index == 0)
    return node;
  if(index == 0){
    node.next = head;
    head = node;
    return node;
  }
  ListNode cur = head;
  for(int i = 0; cur != null && i < index - 1; i++){
    cur = cur.next;
  }
  if(cur == null)
    return head;
  if(cur.next == null){
    cur.next = node;
    return head;
  }
  node.next = cur.next;
  cur.next = node;
  return head;
}
//delete list of nodes
ListNode newHead = new ListNode(0);
  public ListNode deleteNodes(ListNode head, int[] indices) {
    if(head == null || indices.length == 0 || indices == null) {
    	return null;
    }
     for (int i = 0; i < indices.length; i++) {
       if (i == 0) {
           newHead = delete(head, indices[i]);
       } else {
           newHead = delete(newHead, indices[i] - i);
       }
     }
     return newHead;
  }
//delete index
public ListNode delete(ListNode head, int pos) {
  if (head == null) {
      return head;
  }
  //delete at head
  ListNode cur = head;
  if (pos == 0) {
      head = head.next;
      return head;
  }
  for (int i = 0; cur != null && i < pos - 1; i++) {
      cur = cur.next;
  }
  // If position is more than number of ndoes
  if (cur == null || cur.next == null) {
      return head;
  }
  //ListNode next = cur.next.next;
  cur.next = cur.next.next;
  return head;
}
//delete value
public ListNode deleteElement(ListNode head, int target){
  if(head == null)
    return head;
  ListNode dummy = new ListNode(0);
  ListNode cur = dummy;
  dummy.next = head;

  while(cur.next != null && cur.next.value != target){
    cur = cur.next;
  }
  cur.next=cur.next.next;
  return dummy.next;
}
public ListNode deleteDuplicate1(ListNode head, int target){
  if(head == null)
    return head;
  ListNode dummy = new ListNode(0);
  ListNode cur = dummy;
  dummy.next = head;

  while(cur.next != null){
    if(cur.next.value == target){
      cur.next = cur.next.next;
  }else{
      cur = cur.next;
    }
  }
  return dummy.next;
}
//sorted
public ListNode deleteDuplicate0(ListNode head){
  if(head == null)
    return head;
  ListNode dummy = new ListNode(0);
  ListNode cur = dummy;
  dummy.next = head;

  while(cur.next != null && cur.next.next != null){
    if(cur.next.value == cur.next.next.value){
      target = cur.next.value;
      while(cur.next != null && cur.next.value == target){
        cur.next = cur.next.next;  //might be null  
      }
    }else{
      cur = cur.next;
    }
  }
  return dummy.next;
}
