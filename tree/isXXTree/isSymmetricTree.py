def isSymmetric(root):
	if root is None:
		return True
	return helper(root.left, root.right)

def helper(node1, node2):
	if node1 is None and node2 is None:
		return True
	if node1 is None or node2 is None:
		return False
	if node1.val != node2.val:
		return False
	return helper(node1.left, node2.right) and helper(node1.right, node2.left)
