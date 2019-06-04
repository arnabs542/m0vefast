def getKeysInRange(root, min, max):
	res = []
	helper(res, root, min, max)
	return res
# res will be in order
def helper(res, root, min, max):
	if root is None:
		return
	# traverse left Tree
	if root.key > max:
		helper(root.left, res, min, max)
	if root.key <= max and root.key >= min:
		res.append(root.key)
	if root.key < min:
		heper(root.left, res, min, right)
