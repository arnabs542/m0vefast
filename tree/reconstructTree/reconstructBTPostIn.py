def reconstructBTPostIn(postorder, inorder):
    if not postorder, inorder:
        return None

    root_value = post[-1]
    root_index = inorder.index(root_value)
    root = TreeNode(root_value)

    root.left = reconstructBTPostIn(postorder[:root_index], inorder[:root_index])
    root.right = reconstructBTPostIn(postorder[root_index+1:-1], inorder[root_index+1:])
    return root
