def maxDepth(self, root: TreeNode) -> int:
    if root is None:
        return 0
    return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

# mindepth is the shorpest path length of a tree
def minDepth(root)
    if root is None:
            return 0
        if root.left and root.right:
            return min(self.minDepth(root.left), self.minDepth(root.right))+1
        if root.left:
            return 1 + self.minDepth(root.left)
        else:
            return 1 + self.minDepth(root.right)
