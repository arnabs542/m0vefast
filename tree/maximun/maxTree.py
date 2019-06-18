# https://leetcode.com/problems/maximum-binary-tree/submissions/
def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
    if nums is None or not nums:
        return None
    root_value = max(nums)
    root = TreeNode(root_value)
    root.left = self.constructMaximumBinaryTree(nums[:nums.index(root_value)])
    root.right = self.constructMaximumBinaryTree(nums[nums.index(root_value)+1:])
    return root

# https://leetcode.com/problems/maximum-binary-tree-ii/
'''
follow up : Suppose B is a copy of A with the value val appended to it.  It is guaranteed that B has unique values.
Return Construct(B).

If the value is greater than current node, then the entire current node becomes the left child.
If the value is lesser than the current node, then we recurse on the right child.


Time Complexity:
O(N) time,
O(N) recursion space.
'''
# assuming we already have A
def insertIntoMaxTree(self, root: TreeNode, val: int) -> TreeNode:
    if root is None:
        return root
    if root.val > val:
        root.right = self.insertIntoMaxTree(root.right, val)
        return root
    else:
        newroot = TreeNode(val)
        newroot.left = root  # why left not right?!
        return newroot
