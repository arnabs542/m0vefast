# O(n) solutionh check all node's height with early return
def isBalanced(root):
	if root is None:
		return True

	return getHeight(root) != -1

def getHeight(root):
	if root is None:
		return 0
	left = getHeight(root.left)   # ask child
	right = getHeight(root.right)
	if left == -1 or right == -1 or abs(left -  right) > 1:  # what to return at this level 
		return -1
	return max(left, right) + 1  # report to parent
