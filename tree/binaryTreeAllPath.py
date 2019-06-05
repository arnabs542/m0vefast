def binaryTreeAllPath(root):
    res = []
    paht = ""
    dfs(root, res, path)
    return res

# branching factor: left, right child
# depth: reach the end of node
def dfs(node, res, path):
    # prune
    if node is None:
        return
    path = path + '->' + node.value
    # base case
    if node.left is None and root.right None:
        res.append(path[2:])  # exclude -> that was added at the first when paht is empty
        return
    # two branching factor
    if root.left:
        dfs(root.left, res, path)
    if root.right:
        dfs(root.right, res, path)
