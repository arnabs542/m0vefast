# iterative
def inorderTraversal(self, root: TreeNode) -> List[int]:
	if root is None:
		return []

	res = []
	stack = []
	cur = root

	while stack or cur is not None:
		while cur is not None:
			stack.append(cur)
			cur = cur.left

		cur = stack.pop()
		res.append(cur.val)
		cur = cur.right

	return res


def preOrderTraversal(root):
	if not root:
		return []
	res = []
	stack = collections.deque([root])
	stack.push(root)  # save, add as pop

	while stack:
		node = stack.pop()
		res.append(node.val)
		if node.right:    # save right child
			stack.append(node.right)
		if node.left:
			stack.append(node.left)

	return res

def postorderTraversal(root):
	if not root:
		return []
	res = []
	stack = [root]

	while stack:
		node = stack.pop()
		res.insert(0, node.val)
		if node.left:
			stack.push(node.left)
		if node.right:
			stack.push(node.right)

	return res

# recursion
def inOrderTraversal(root):
	res = []
	self.helper(root, res)
	return res
def helper(self, root, res):
	if not root:
		return
	helper(root.left)
	res.append(res.val)
	helper(root.right)

def preOrderTraversal(root):
	res = []
	self.helper(root.res)
	return res
def helper(self, root, res):
	if not root:
		return
	res.append(res.val)
	helper(root.left)
	helper(root.right)

def postorderTraversal(root):
	res = []
	self.helper(root.res)
	return res
def helper(self, root, res):
	if not root:
		return
	helper(root.right)
	helper(root.left)
	res.append(root.val)

# devide and conquer
def postorderTraversal(root):
	res = []
	if not root:
		return res
	left = postorderTraversal(root.left)
	right = postorderTraversalroot.right)
	res.append(left)
	res.append(root.val)
	res.append(right)
	return res
