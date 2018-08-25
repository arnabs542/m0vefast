//part of reverseAlternateNopdes
public ListNode oddEvenList(ListNode head) {
  if(head == null || head.next == null)
    return head;
  ListNode[] heads = new ListNode[]{new ListNode(0), new ListNode(0)};
  ListNode[] cur = new ListNode[2];
  cur[0] = heads[0];
  cur[1] = heads[1];
  boolean isAlt = false;
  while(head != null){
    if(isAlt){
      cur[1].next = head;
      cur[1] = cur[1].next;
    }else{
      cur[0].next = head;
      cur[0] = cur[0].next;
    }
    isAlt ^= true;   //^ (bitwise XOR)
    head = head.next;
  }
  cur[1].next = null;
  cur[0].next = heads[1].next;
  return heads[0].next;
}
  Example:
  Given 1->2->3->4->5->NULL,
  return 1->3->5->2->4->NULL.
