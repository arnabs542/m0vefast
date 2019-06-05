def binaryTreeAllPath(root):
    res = []
    paht = ""
    dfs(root, res, path)
    return res

# branching factor: left, right child
# depth: reach the end of node
def dfs(node, res, path):
    # base case
    if node.left is None and root.right None:
        res.append(path + str(root.val)
        return
    # two branching factor
    if root.left:
        dfs(root.left, res, path + str(root.val) + '->')
    if root.right:
        dfs(root.right, res, path + str(root.val) + '->')
