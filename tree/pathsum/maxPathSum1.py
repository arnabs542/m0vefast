# max path 1: node to node (no constrain)
def maxpathsum1(root):
    self.max = root.val
    dfs(root)
    return max
# max of a xingle path
def maxpath_singlepath(root):
    if root is None:
        return 0
    left = dfs(root.left)
    right = dfs(root.right)
    left = 0 if left < 0 else left
    right = 0 if right < 0 else right
    # update max
    self.max = max(root.val + left + right, self.max)
    # return single path
    return root.key + max(left, right)
