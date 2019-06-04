def isbst(root):
	if root is None:
		return False
	return self.helper(root.left, float('-inf'), float('inf'))
def helper(node, small, big):
	# base case:
	if node is None:
		return True
	if node.val <= small or node.val >= big:
		return False
	return self.helper(node.left, small, node.va) and self.helper(node.right, node.val, big)
