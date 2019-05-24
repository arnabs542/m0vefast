def levelOrder(self, root: TreeNode) -> List[List[int]]:
    if root is None:
        return []

    res = []
    queue = collections.deque([root])

    while queue:
        level = []
        for _ in range(len(queue)):
            node = queue.popleft()
            level.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        res.append(level)

    return res
