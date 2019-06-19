#L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
#L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
def reorder(head):
	if head is None or head.next is None:
		return head
	# find mid
	mid = self.findmid(head)
	second = mid.next
	mid.next = None
	# reverse
	newHead = self.reverse(second)
	# interleave
	return self.interleave(head, newHead)

def findmid(head):
	slow = head
	fast = head
	while fast.next and fast.next.next:
		fast = fast.next.next
		slow = fast.next
	return slow

def reverse(head):
	if head is None or head.next is None:
		return head

	prev = None
	while head:
		next = head.next
		head.next = prev
		prev = head
		head = next
	return prev

def interleave(node1, node2):
	dummy = ListNode(0)
	cur = dummy
	while node1 and node2:
		cur.next = node1
		cur.next.next = node2
		node1 = node1.next
		node2 = node2.next
		cur = cur.next.next
	if node1:
		cur.next = node1
	elif node2:
		cur.next = node2
	return dummy.next
