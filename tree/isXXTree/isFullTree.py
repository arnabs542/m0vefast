# except leaf node, other nodes should have 2 nodes
def isfulltree(root):
    # edge case
    if root is None:
        return True
    # base case: if leaf node:
    if root.left is None and root.right is None:
        return True
    # other nodes
    if root.left and root.right:
        return isfulltree(root.left) and isfulltree(root.right)
    return False
