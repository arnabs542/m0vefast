# O(n) solution
def constructBSTPre(preorder):
    self.index = 0    # self.index has to be a gloabl varibale here!
    return helper(preorder, float('inf'))

def helper(preorder, index, bound):
    if self.index == len(preorder) or preorder[self.index] > bound:
        return None

    root = TreeNode(preorder[self.index])
    self.index += 1
    root.left = constructBSTPre(preorder, root.val)
    root.right = constructBSTPre(preorder, bound)
    return root



# O(nlgn) solution
def bstFromPreorder(self, A):
    def helper(i, j):
        if i == j:
            return None
        root = TreeNode(A[i])
        mid = bisect.bisect(A, A[i], i + 1, j)
        root.left = helper(i + 1, mid)
        root.right = helper(mid, j)
        return root
    return helper(0, len(A))
