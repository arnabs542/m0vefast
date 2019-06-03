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
            pre = helper(pre, cur.next)  # pre (thiscur.next (next group head), return the reversed tail
            cur = pre.next
        else:
            cur = cur.next

    return dummy.next

# reverse, return the new head and connect to the next head
def helper(pre, next):
    oldhead = pre.next  # alwasy be the old head
    cur = last.next
    while cur is not next:
        last.next = cur.next    # 1.next = 3
        cur.next = pre.next     # 2.next = 1       # prev.next: alwasy the left most one   [drag]
        pre.next= cur       # 0.next = 2            # cur: alwasy will put to the left in next round
        cur = last.next       # 2 = 3
    return oldhead


''' k=4
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
