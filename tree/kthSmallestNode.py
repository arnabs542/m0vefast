def kthSmallestNode(root, k):
    leftsize = getsize(root.left)
    if size >= k:
        return kthSmallestNode(root.left, k)
    if size == k-1:
        return root.value
    else:
        return kthSmallestNode(root.right, k-size-1)


def getsize(root):
    if root is None:
        return 0
    return 1 + getsize(root.left) + getsize(root.right)
