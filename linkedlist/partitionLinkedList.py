'''
1,5,2,8,9     4
1,2,5,8,9
'''
def partition(head):
	smallhead = ListNode(0)
	small = smallhead
	bighead = ListNode(0)
	big = bighead

	while head:
		if head.val < target:
			small.next = head
			small = small.next
		else:
			big.next = head
			big = big.next
		head = head.next
		
	small.next = big.next
	big.next = None
	return small.next
