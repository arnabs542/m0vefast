def reverse(head):
    if head is None or head.next is None:
        return head

    next = head.next
    newHead = reverse(head.next)
    next.next = head
    head.next = None
    return newHead

def reversePair(head):
    if head is None or head.next is None:
        return head

    newHead = head.next
    head.next = reversePair(head.next.next)
    newHead.next = head
    return newHead

def reverseK(head, k):
    if head is None or k == 1:
        return head

    dummy = node(0)
    dummy.next = head
    cur = head
    pre = dummy

    i = 0
    while cur:
        i += 1  # ith node(1-index)
        if i % k == 0:
            pre = helper(pre, cur.next)  # pre = 1 
            # 321->45678910
            cur = pre.next  # cur = 4
        else:
            cur = cur.next

    return dummy.next

# reverse, return the new head and connect to the next head
def helper(pre, next):
    oldhead = pre.next  # oldhead = 1
    cur = oldhead.next  # cur = 2
    while cur is not next:   # 2 != 4
        oldhead.next = cur.next    # 1.next = 3
        cur.next = pre.next     # 2.next = 1
        pre.next= cur       # null.next(1) = 2 
        cur = oldhead.next  # 2 = 3    
    return oldhead    # return 1


''' k=3
null-1,2,3,4,5(next)
null-2,1,3,4,5(next)
null-3-2-1-4-5(next)
null-4-3-2-1-5(next)
null-4-3-2-1-6-5..
'''




/* k  = 3
 * 0->1->2->3->4->5->6
 * |           |
 * pre        next

 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next
 */
