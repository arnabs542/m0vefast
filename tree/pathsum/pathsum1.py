def pathsum1(root, sum):
    if root is None:
        return False

    left = pathsum1(root.left, sum-root.val)
    right = pathsum2(root.right, sum-root.val)

    if left is None and right is None and sum == root.val:
        return True


    return left or right

def pathsum1(root, sum):
    if root is None:
        return []
    res = []
    dfs(root, sum, [], res)
    return res

def dfs(root, sum, path, res):
    if root is None:
        return
    if root.left is None and root.right is None and sum == root.val:
        res.append(path+[root.val])
        return
    dfs(root.left, sum-root.val, path+[root.val], res)
    dfs(root.right, sum-root.val, path+[root.val], res)



# dfs find all path
def dfs(node, res, path):
    if root is None:
        return
    # reach the depth
    if node.left is None and root.right None:
        res.append(path + str(root.val)
        return
    # two branching factor
    #if root.left:
        dfs(root.left, res, path + str(root.val) + '->')
    #if root.right:
        dfs(root.right, res, path + str(root.val) + '->')
