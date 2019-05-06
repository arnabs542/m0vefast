def merge(one, two):
	dummy = ListNode(0)
	cur = dummy
	while not one and not two:
		if one.value < two.value:
			cur.next = one
			one = one.next
		else:
			cur.next = two
			two = two.next
		cur = cur.next
	while not one:
		cur.next = one
	while not two:
		cur.next = two
	return dummy.next
