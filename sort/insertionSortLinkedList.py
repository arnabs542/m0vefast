# O(n^2) for linkedlist
def insertion_sort(head):
    dummy_head = ListNode(0, head)  # (value, next)
    while head and head.next:
        if head.value > head.next.value:
            target = head.next
            pre = dummy_head
            while(pre.next.value < target.value):
                pre = pre.next

            temp = pre.next
            pre.next = target
            head.next = target.next

        else:
            head = head.next

    return dummy_head
