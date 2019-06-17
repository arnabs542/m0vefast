# O(n * height) O(height)
# dfs time o(height)
def pathsum2(root, sum):
    if root is None:
        return []
    res = []
    dfs(root, sum, [], res)
    return res
# traverse -> validate each path
def dfs(root, sum, path, res):
    if root is None:
        return
    # preorder
    pathsum1(root, res, path, res):
    dfs(root.left, sum, path, res)
    dfs(root.right, sum, path, res)

def pathsum1(root, sum, path, res):
    if root is None:
        return

    # if root.left is None and root.right is None and sum == root.val:
    if sum == root.val:
        res.append(path+[root.val])
        # return

    pathsum1(root.left, sum-root.val, path+[root.val], res)
    pathsum1(root.right, sum-root.val, path+[root.val], res)


# https://leetcode.com/problems/path-sum-iii/discuss/141424/Python-step-by-step-walk-through.-Easy-to-understand.-Two-solutions-comparison.-%3A-)
