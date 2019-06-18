# https://leetcode.com/problems/minimum-absolute-difference-in-bst/
def getMinimumDifference(self, root: TreeNode) -> int:
    #gloabl min
    #inorder traverse
    gloabl_min = float('inf')

    res = []
    stack = []
    cur = root
    while cur or stack:
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()
        res.append(cur.val)
        cur = cur.right

    for i in range(len(res)-1):
        gloabl_min = min(gloabl_min, res[i+1]-res[i])

    return gloabl_min
