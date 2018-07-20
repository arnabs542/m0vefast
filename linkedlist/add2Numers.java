public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode p3 = dummy;
    while(p1 != null || p2 != null){
      if(p1 != null){
        carry += p1.value;
        p1 = p1.next;
      }
      if(p2 != null){
        carry += p2.value;
        p2 = p2.next;
      }
      p3.next = new ListNode(carry % 10);
      p3 = p3.next;
      carry / 10;
    }
    if(carry == 1)
      p3.next = new ListNode(1);
    return dummy.next;
  }
