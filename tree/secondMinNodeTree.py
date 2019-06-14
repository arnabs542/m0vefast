'''
the property root.val = min(root.left.val, root.right.val) always holds.
'''
def secondMinNode(root):
    res = [float('inf')]
    def traverse(node):
        # recursive rule: return the smallest node that are larger than root node
        if node is None:
            return
        if root.val < node.val < res[0]:
            res[0] = node.val
        traverse(root.left)
        traverse(root.right)

    traverse(root)
    return -1 if res[0] == float('inf') else res[0]
