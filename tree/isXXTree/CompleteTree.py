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


def isCompleteTree(root):
	queue = [root]
	i = 0  # # i is the first empty node index by order
	while queue[i]:
		queue.append(queue[i].left)
		queue.append(queue[i].right)
		i += 1
	return not any(queue[i:])

# count the total nodes if a complete Tree
def countNodes(self, root: TreeNode) -> int:
	queue = [root]
	i = 0
	while queue[i]:
		queue.append(queue[i].left)
		queue.append(queue[i].right)
		i += 1
	return i
