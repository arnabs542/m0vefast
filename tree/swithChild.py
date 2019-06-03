def switchChild(root):
    if root is None:
        return root
    left = switchChild(root.left)
    right = switchChild(root.right)
    root.right, root.left = root.left, root.right
    return root
