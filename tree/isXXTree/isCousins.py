#same level but diferent parents
def isCousion(root, node1, node2):
    if root is None:
        return False
    return findLevel(root, node1, 0) == findLevel(root, node2, 0) and not isSibling(root, node1, node2)

def findLevel(root, node, depth):
    if root is None:
        return 0
    if root == node:
        return depth
    res = findLevel(root.left, node, depth+1)
    if res == 0:
        findLevel(root.right, node, depth+1)
    return res

def isSibling(root, node1, node2):
    if root is None:
        return False
    if root.left and root.right:
        if (root.left == node1 and root.right == node2) or (root.left == node2 and root.left == node2):
            return True

    return isSibling(root.left, node1, node2) or isSibling(root.right, node1, node2)
