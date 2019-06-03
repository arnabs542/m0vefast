#solution1: using hashmap to avoid copy multiple times for the same node
#O(n)
'''
node.value
node.next
node.random

- hashmap <originalnode, copiednode>
- .value: 0) valid(no necessary, since while loop)
				1)checkmap,
				 2) copy
- .next: no need
- .random; 1) valid
					2)checkmap
					3)copy
'''
def deepcopylist(head):
	if head is None or head.next is None:
		return head

	dummy = ListNode(0)
	dummy.next = head
	cur = dummy
	dict = {}

	while head:
		# .value
		if head not in dict:
			dict[head] = ListNode(head.val)
		cur.next = dict.get(head)
		# .next no need since for loop
		# .random
		if head.random:
			if head.random not in dict:
				dict[head.random] = ListNode(head.random)
			cur.next.random(dict.get(head.random))
		# update
		cur = cur.next
		head = head.next

	return dummy.next
