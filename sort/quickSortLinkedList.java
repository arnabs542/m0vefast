public ListNode quickSort(ListNode head) {
    // write your solution here
    if(head == null || head.next == null) {
      return head;
    }
    //use mid as pivotPoint
    ListNode dummy1 = new ListNode(0);
    ListNode dummy2 = new ListNode(0);
    ListNode mid = findMiddle(head);
    partition(head, mid, dummy1, dummy2);
    dummy1.next = quickSort(dummy1.next);
    dummy2.next = quickSort(dummy2.next);

    ListNode tail1 = findFirstHalfTail(dummy1.next);
    if(dummy1.next == null) {
      dummy1.next = mid;
    } else {
      tail1.next = mid;
    }
    mid.next = dummy2.next;
    return dummy1.next;
  }
  private ListNode findFirstHalfTail(ListNode head) {
    while(head != null && head.next != null) {
      head = head.next;
    }
    return head;
  }

  private ListNode findMiddle(ListNode head) {
    ListNode fast = head.next;
    ListNode slow = head;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  private void partition(ListNode head, ListNode mid, ListNode dummy1, ListNode dummy2) {
    ListNode cur2 = dummy2;
    ListNode cur1 = dummy1;
    while(head != null) {
      if(mid.value < head.value) {
        cur2.next = head;
        cur2 = cur2.next;
      } else if(mid.value > head.value){
        cur1.next = head;
        cur1 = cur1.next;
      }
      head = head.next;
    }
    //cut the ties
    cur1.next = null;
    cur2.next = null;
  }
