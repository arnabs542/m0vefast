def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
    if not root:
        return []
    queue = collections.deque([root])
    res = []
     # defualt append() pop() from the right side

    layer = 0
    while queue:
        level = []
        for i in range(len(queue)):
            if layer == 0:
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            else:
                node = queue.pop()
                level.append(node.val)
                if node.right:
                    queue.appendleft(node.right)
                if node.left:
                    queue.appendleft(node.left)

        layer = 1 - layer
        res.append(level)
    return res


                
