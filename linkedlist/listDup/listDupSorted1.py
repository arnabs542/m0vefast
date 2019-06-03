# start from head, look for next two 
def removeDuplicate1(head):
    if head is None or head.next is None:
        return head
    cur = head
    while cur and cur.next:
        if cur.next.val == cur.next.val:
            cur.next = cur.next.next
        else:
            cur = cur.next

    return head
