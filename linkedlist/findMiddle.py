# L = 1 -> 2 -> 3 -> null, return 2
# L = 1 -> 2 -> 3 -> 4 -> null, return 2

def findMid(head):
	if head is None or head.next is None:
		return head
	slow = head
	fast = head
	while fast.next and fast.next.next:
		slow = slow.next
		fast = fast.next.next
	return slow
