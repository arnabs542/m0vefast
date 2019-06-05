# O(height)
def LCA_bst(root, node1, node2):
    if root is None:
        return root
    if root.value < node1.value and root.value < node2.value:
        return LCA_bst(root.left, node1, node2)
    if root.value > node1.value and root.value > root2.value:
        return LCA_bst(root.right, node1, node2)
    return root
    
