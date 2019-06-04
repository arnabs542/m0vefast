def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
    if not root:
        return []
    deque = collections.deque([root])
    res = []
     # defualt append() pop() from the right side

    layer = 0
    while deque:
        level = []
        for i in range(len(queue)):
            if layer == 0:
                node = deque.popleft()  # generate from left
                level.append(node.val)
                if node.left:
                    deque.append(node.left)   #left and right to right
                if node.right:
                    deque.append(node.right)
            else:
                node = deque.pop()
                level.append(node.val)
                if node.right:
                    deque.appendleft(node.right)
                if node.left:
                    deque.appendleft(node.left)

        layer = 1 - layer
        res.append(level)
    return res
