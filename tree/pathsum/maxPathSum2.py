def maxpathsum2(root):
    if root is None:
        return float('-inf')
    self.max = root.val
    self.dfs(root)
    return self.max
# return single path
def dfs(root):
    if root is None:
        return 0
    left = self.dfs(root.left)
    right = self.dfs(root.right)
    # can not drop negative value, since leaf to leaf

    # has two child (update)
    if root.left and root.right:
        self.max = max(self.max, left+right+root.val)
        return max(left,right) + root.val
    # has only one child
    if not root.left:
        return root.val + right
    else:
        return root.val + left
