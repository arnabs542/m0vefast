# sorted array to a hight balanced tree
def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
    if nums is None or len(nums) == 0:
        return None
    return helper(nums, 0, len(nums)-1)

def helper(nums, left, right):
    if left > right:
        return None
    mid = left + (right - left)//2
    root = TreeNode(nums[mid])
    root.left = helper(nums, left, mid-1)
    root.right = helper(nums, mid+1, right)
    return root



# sorted list to a hight balanced bst
def sortedListToBST(self, head: ListNode) -> TreeNode:
    if head is None:
        return head

    return self.dfs(head)

def dfs(self, head):
    # return condition
    if head is None:
        return None
    if head.next is None:
        return TreeNode(head.val)

    slow = fast = head
    # fast = head.next.next
    # while fast and fast.next:
    while fast.next and fast.next.next:
        fast = fast.next.next
        slow = slow.next
    right = slow.next
    slow.next = None

    root = TreeNode(slow.val)
    root.left = self.dfs(head)
    root.right = self.dfs(right)

    return root
