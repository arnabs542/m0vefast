# inorder
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        cur = root
        while cur:
            stack.append(cur)
            cur = cur.left

    def next(self) -> int:
        """
        @return the next smallest number
        """
        cur = stack.pop()
        res = cur.value
        if cur.right:
            while cur:
                stack.append(cur)
                cur = cur.left
        return res


    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) > 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


def inOrderTraversal(root):
    if root is None:
        return []

    res = []
    stack = []
    cur = root
    while root or cur:
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()
        res.append(cur.value)
        cur = cur.next
    return res
