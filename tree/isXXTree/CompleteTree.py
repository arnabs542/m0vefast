# all nodes on the left side
# level order, from left to right
def isCompleteTree(root):
	if root is None:
		return
	queue = collections.deque([root])
	isSeen = False

	while queue:
		node = queue.popleft()
		if node.left is None:
			isSeen = True
		elif isSeen:   # there is a left node
			return False
		else:
			queue.append(node.left)

		if node.right is None:
			isSeen = True
		elif isSeen:
			return False
		else:
			queue.append(node.right)
	return True
