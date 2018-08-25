public ListNode reverseKGroup(ListNode head, int k) {
    if(head==null||k==1)
        return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;

    i = 0;
    while(cur != null){
        i++;
        if(i % k == 0){
            pre = reverse(pre, cur.next);
            cur = pre.next;
        }else{
            cur = cur.next;
        }
    }

    return dummy.next;
}

/*
 * 0->1->2->3->4->5->6
 * |           |
 * pre        next

 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next
 */
public ListNode reverse(ListNode pre, ListNode next){
    ListNode last = pre.next;  //not changing
    ListNode curr = last.next;  //move to the next till cur = next

    while(curr != next){
        last.next = curr.next;   //tail connect to next block (looking at while loop condition), also for cur next move
        curr.next = pre.next;   //next middle after reverse
        pre.next = curr;  //pre.next alwasy chasing to the new tail
        curr = last.next;
    }

    return last;
}
