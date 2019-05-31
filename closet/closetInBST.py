def cloestBST(root, target):
    res = root.key
    while root is not None:
        if root.key == target:
            return root.key
        else:
            if(abs(root.key) - target) < abs(res - target):
                res = root.key
            if root.key < target:
                root = root.right
            else:
                root = root.right
    return res
