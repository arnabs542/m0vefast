# recursion
def reverselinkedlist(head):
	if head is None or head.next = None:
		return head
	# remember
	next = head.next
	newhead = reverselinkedlist(head.next)  # once it reaches the end, it will alwasy be the same node
	# mutual
	next.next = head
	head.next = None

	return newhead

# iterative
def reverselinkedlist(head):
	if head is None or head.next is None:
		return head

	prev = None
	while head:
		next = head.next  # remember next
		head.next = prev  # update next
		prev = head     # remembr prev
		head = next     # move
	return prev


















def reverse(head):
	if head is None or head.next is None:
		return head

	next = head.next   # remember, mutual,
	newHead = reverse(head.next)
	next.next = head   # mutual
	head.next = None

	return newHead

def reverse2(head):
	if head is None and head.next is None:
		return head

	prev = None
	while head:
		next = head.next   # remember
		next.next = head   # mutual
		head.next = prev

		head = next		   # move
	return prev
