def reverse(head):
    next = head.next
    newHead = reverse(head.next)
    next.next = head
    head.next = None
    return newHead

def reversePair(head):
    if head is None or head.next is None:   # base case, smallest problem
        return head

    newHead = head.next   # what to return
    head.next = reversePair(head.next.next)  # subproblem and how does current level connect with subproblem
    newHead.next = head
    return newHead

def reverse(head):
    if head is None or head.next is None:
        return head

    prev = None
    while head:
        next = head.next
        head.next = prev
        prev = head
        head = next
    return prev
    
# still have not figure out
def reversePair(head):
    dummy = node(0)
    dummy.next = head
    cur = dummy
    while cur.next and cur.next.next:
        newHead = cur.next.next  # remember next
        cur.next.next = cur.next.next.next  # mutual
        newHead.next = cur.next
        cur.next = newHead

        cur = cur.next.next  # mnove
    return dummy.next

//iteration
public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while(cur.next != null && cur.next.next != null){
    	ListNode newHead = cur.next.next;  //=> 2 newhead
    	cur.next.next = cur.next.next.next;  //<= 2.next = 1
    	newHead.next = cur.next; //=> 0.next = 3
        cur.next = newHead;
    	cur = cur.next.next;  //move
    }
    return dummy.next;
}
1->2->3->4->5
2->1->4->3-
