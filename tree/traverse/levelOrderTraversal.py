def levelOrder(root):
	if root is None:
		return []

	res = []
	queue = collections.deque([root])

	while queue:
		level = []
		for _ in range(len(queue)):
			node = queue.popleft()
			level += [cur.val]  # level.append(cur.val)
			if node.left:
				queue.append(node.left)
			if node.right:
				queue.append(node.right)
		res.append(level)

	return res

def levelOrder(root):
	if root is None:
		return []

	res = []
	queue = collections.deque([root])

	while queue:
		level = []
		for _ in range(len(queue)):
			node = queue.popleft()
			level += [cur.val]
			if node.left:
				queue.append(node.left)
			if node.right:
				queue.append(node.right)
		res.append(level)

	return res[::-1]
