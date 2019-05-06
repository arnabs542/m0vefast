def mergesort(head):
    if not head or not head.next:
        return head

    # find middle and divide them into 2 parts
    midnode = findmid(head)
    left = head
    right = midnode.next
    midnode.next = None

    # recursion on each side
    lefthead = mergesort(left)
    righthead = mergesort(right)

    # merge
    finalhead = merge(lefthead, righthead)
    return finalhead

def findmid(head):
    if not head or not head.next:
        return head

    slow = head
    fast = head.next
    while not fast and not fast.next and
        slow = slow.next
        fast = fast.next.next
    return slow

# iterative merge
def merge(left, right):
    dummy = ListNode(0)
    cur = dummy
    while not left and not right:
        if left.value < right.value:
            cur.next = left
            left = left.next
        else:
            cur.next = right
            right = right.next
        cur = cur.next
    return dummy.next
    
# recursive merge
def merge(left, right):
    if not left:
        return right
    if not right:
        return left
    if left.value <= right.value:
        left.next = merge(left.next, right)
    else:
        right.next = merge(right.next, left)
