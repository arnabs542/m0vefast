# https://leetcode.com/problems/sum-of-left-leaves/submissions/
# solution1:  top down:
def sumOfLeftLeaves(root):
    if not root:
        return 0
    if root.left and not root.left.left and not root.left.right:
        return root.left.val + sumOfLeftLeaves(root.right)
    reutrn sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
# solution2: bfs (top down )
def sumOfLeftLeaves(root):
    if root is None or (root.left is None and root.right is None):
        return 0
    res = 0
    queue = collections.deque([root])
    while queue:
        cur = queue.popleft()
        if cur.left and not cur.left.left and not cur.left.right:
            res += cur.left.val
        if cur.left:
            queue.append(cur.left)
        if cur.right:
            queue.append(cur.right)
    return res

# solution3: bototm up
# 递归遍历二叉树的节点，判断当前节点是否有左儿子，进而判断左儿子是否为叶子节点。
def sumOfLeftLeaves(root):
    if root is None or (root.left is None and root.right is None):
        return 0
    total = helper(root, True)
    return total

def helper(root, isLeft):
    # recursion base case, child node
    if root is None:
        return None
    # 1)
    left = helper(root.left, True)
    right= helper(root.right, False)
    # 2) and 3

    # deal with child node
    # only return value
    if left is None and right is None and isLeft:
        return root.val

    # deal with node with children
    # has both children
    if left and right:
        return left + right

    # has one child
    if left:
        return left
    if right:
        return right
    # all other case: left right returns 0
    # left right returns none and is right child
    return 0




# https://leetcode.com/problems/find-bottom-left-tree-value/
# try this testcase: [1,2,3,4,null,5,6,null,null,null,7,6,7,null,null,null,null,null,9]
# solution1: bfs from right to left bottom up pre order  O(n)  O(n)
# same level, find the left most one node
def findBottomLeftValues(root):
    queue = [root]
    for node in queue:
        if queue.right:
            queue += [node.right]
        if queue.left:
            queue += [node.left]
    return node.val

# solution2: bottom up  O(height) O(height)
# only update when level is update, and capture the left one first
def findBottomLeftValues(root):
    res = 0
    maxlevel = 0
    helper(root, res, maxlevel, 1)
    return res
def helper(root, res, maxlevel, curlevel):
    if root is None:
        return
    if curlevel > maxlevel:
        maxlevel = curlevel
        res = cur.val
    helper(root.left, res, maxlevel, curlevel+1)
    helper(root.right, res, maxlevel, curlevel+1)
