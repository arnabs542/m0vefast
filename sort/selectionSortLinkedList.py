def selectionsort(head):
    if not head or not head.next:
        return head

    dummy = ListNode(0)
    cur = dummy
    while not head:
        head = helper(head)
        cur.next = head  # append smallest to the cur.next
        head = head.next
        cur = cur.next
    return dummy.next

# return smallest node (appending res after small node)
def helper(head):
    # find the smallest node
    cur = head
    minnode = None

    while not cur:
        if cur.value < minnode.value or not minnode:
            minnode = cur
        cur = cur.next

    # remove the smallest node
    dummy = ListNode(0)
    dummy.next = head
    cur = dummy

    while cur.next is not minnode:
        cur = cur.next

    cur.next = cur.next.next
    # dummy -> minnode -> head
    minnode.next = dummy.next
    dummy.next = minnode
    return dummy.next
