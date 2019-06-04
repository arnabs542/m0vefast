# inorder
def inorder(root):
    if root is None:
        return []
    cur = root
    stack = []
    res = []
    while stack or cur:
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()
        res.append(cur.value)
        cur = cur.right
    return res

# preorder
def preorder(root):
    if root is None:
        return []
    stack = [root]
    res = []

    while stack:
        node = stack.pop()
        res.append(root.val)
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
    return res

# postorder
def postorder(root):
    if root is None:
        return []
    stack = [root]
    res = []

    while stack:
        node = stack.pop()
        res.insert(0, node.val)
        if node.left:
            stack.append(node.left)
        if node.right:
            stack.append(node.right)
    return res

# levelOrder
def levelOrder(root):
    if root is None:
        return []
    res = []
    deque = collections.deque([root])

    while deque:
        cur = []
        for _ in range(len(queue)):
            node = deque.popleft()
            cur += node.val
            if node.left:
                deque.append(node.left)
            if node.right:
                deque.append(node.right)
        res.append(cur)
    return res

# zigzap
def ziazap(root):
    if root is None:
        return []
    res = []
    deque = collections.deque([root])
    layer = 0
    while deque:
        cur = []
        for _ in range(len(deque)):
            if layer == 0:
                node = deque.popleft()
                cur.append(node.val)
                if node.left:
                    deque.append(node.left)
                if node.right:
                    deque.appendLeft(node.right)
            else:
                node. = deque.pop()
                cur.append(node.val)
                if node.right:
                    deque.appendleft(node.right)
                if node.left:
                    deque.appendLight(node.left)
        res.append(cur)
        layer = 1 - layer

    return res
# vertical order by left to right: distance to root
'''
[
  [9],
  [3,15],
  [20],
  [7]
]
'''
def verticalOrder(root):
    if root is None:
        return []
    # dict{distance_to_root: [list of nodes]}
    # queue for level order traversal (node, distance_to_root)
    dict = defaultdict(list)
    queue = collections.deque([(root,0)]) # order does not matter
    res = []
    while queue:
        cur_node, cur_dist = queue.popleft()
        dict[cur_dist].append(cur_node)
        if cur.node.left:
            queue.append(cur.node.left, cur_dist - 1)
        if cur.node.right:
            queue.append(cur_node.right, cur_dist + 1)

    for distance, nodes in sorted(dict):
        res.append(nodes)
    return res

# vertical Order by small to big: x,y,val and sort
def verticalOrder(root):
    if root is None:
        return []
# queue for level order (node, x, y)
# arr.sort()
    queue = collections.deque([(root, 0, 0)])
    res = []
    while queue:
        node, x, y = queue.popleft()
        arr.append((x, y, node.val))
        if node.left:
            queue.append((node.left, x-1, y+1))
        if node.right:
            queue.append((node.right, x+1, y+1))
    arr.sort()
    res.append([arr[0][2]])
    for i in range(1, len(arr)):
        if arr[i][0] == arr[i-1][0]:
            res[-1].append([arr[i][2]])
        else:
            res.append([arr[i][2]])
    return res
