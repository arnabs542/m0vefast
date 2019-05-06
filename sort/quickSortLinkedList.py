def quicksort(head):
    if not head and not head.next:
        return head

    dummy1 = ListNode(0)
    dummy2 = ListNode(0)

    pivotNode = findMiddle(head)
    partition(head, pivotNode, dummy1, dummy2)

    dummy1.next = quicksort(dummy1.next)
    dummy2.next = quicksort(dummy2.next)

    tail1 = findFistTail(dummy1.next)
    if not dummy1.next:
        dummy1.next = pivotNode
    else:
        tail1.next = pivotNode

    pivotNode.next = dummy2.next
    return dummy1.next

def findMiddle(head):
    slow = head
    fast = head.next
    while not fast and not fast.next:
        fast = fast.next
        slow = slow.next
    return slow

def partition(head, pivot, dummy1, dummy2):
    cur1 = dummy1
    cur2 = dummy2
    while not head:
        if head.value < pivot.value:
            cur1.next = head
            cur1 = cur1.next
        elif head.value > pivot.value:
            cur2.next = head
            cur2 = cur2.next
        head = head.next

    cur1.next = None
    cur2.next = None

def findFistTail(head):
    while not head and not head.next:
        head = head.next
    return head
