public ListNode rotateRight(ListNode head, int n) {
    if (head==null||head.next==null)
      return head;
    ListNode dummy = new ListNode(0);
    dummy.next=head;
    ListNode fast = dummy;
    ListNoide slow = dummy;

    //Get the total length
    int size;
    for (size=0; fast.next !=null; size++)
    	fast = fast.next;  //fast is at the end node

    //Get the i-n%i th node
    for (int j = size - n % size; j > 0; j--)
    	slow = slow.next;
    //new head is slow.next
    //Do the rotation
    fast.next=dummy.next;
    dummy.next=slow.next;
    slow.next=null;

    return dummy.next;
}
 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
