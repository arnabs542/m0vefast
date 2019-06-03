'''
The fast pointer is n steps ahead of the slow pointer.
When the fast reaches the end, the slow pointer points at the previous element of the target element.
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
'''
def removeNthFromEnd(head, n):
    if head is None:
        return head

    fast = head
    slow = head
    # if remove hdad

    while i in range(n):
        fast = fast.next

    # if remove head
    if fast is None:
        head = head.next
        return head
    else:
        while fast.next:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return head
