# assume: no duplicate in inorder, pre not null
def constructBTPreIn(preorder, inorder):
    if not preorder or inorder:
        return None

    root_value = preporder.pop(0)
    root = TreeNode(root_value)
    root_index = inorder.index(root_vaue)
    #preporder.pop(0)  # remove element at certain index

    root.left = constructBTPreIn(preorder, inorder[:root_index])
    root.right = constructBTPreIn(preorder, inorder[root_index+1:])
    return root
