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
           //delete(newHead, indices[i] - i);
       }
     }
     return newHead;
  }
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
        //delete in the middle and tail
        //cur.next is to be deleted
        for (int i = 0; cur != null && i < pos - 1; i++) {
            cur = cur.next;
        }
        // If position is more than number of ndoes
        if (cur == null || cur.next == null) {
            return head;
        }
        ListNode next = cur.next.next;
        cur.next = next;
        return head;
    }
