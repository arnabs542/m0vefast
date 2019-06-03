'''左边小 all reverse 从左到右计算
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4 - > 1)
Output: 7 -> 0 -> 8 -> 1
'''
def add2Number1(node1, node2):
    dummy = ListNode(0)
    cur = dummy
    left = node1
    right = node2
    carry = 0
    while left or right:
        if left:
            carry += left.value
            left = left.next
        if right:
            carry += right.value
            right = right.next
        cur.next = ListNode(carry % 10)
        carry = carry / 10
        cur = cur.next

        if carry != 0:
            cur.next = ListNode(carry)
    return dummy.next
