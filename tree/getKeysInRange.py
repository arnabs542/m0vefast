def getRangeSum(root, left, right):
	self.sum = 0
	self.inorder(root, left, right)
	return self.sum

def inorder(self, root, left, right):
	if root is None:
		return
	if left <= root.val<= right:
		self.sum += root.val
		self.inorder(root.left, left, right)
		self.inorder(root.right, left, right)
	if left > root.val:
		self.inorder(root.right, left, right)
	if right < root.val:
		self.inorder(root.left, left, right)
