def maxpath4(root):
    self.max = root.val
    dfs(root)
    return self.max

def dfs(root):
    if root is None:
        return 0
    left = dfs(root.left)
    right = dfs(root.right)
    left = 0 if left < 0 else left
    right = 0 if right < 0 else right
    # update max with single path max
    self.max = max(self.max, root.val + max(left, right))
    return root.val + max(left, right)
