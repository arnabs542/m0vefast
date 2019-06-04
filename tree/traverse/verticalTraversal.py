# level order, + distance to root (left is -1 distance, right is +1 distance)
# so leftest node alswasy has the smallest value/distance

# if same position, sort from left to right
def verticalOrder(self, root: TreeNode) -> List[List[int]]:
    if root is None:
        return []

    res = []
    queue = collections.deque([(0, root)])
    dist_dict = collections.defaultdict(list)

    while queue:
        node_dist, node = queue.popleft()
        dist_dict[node_dist].append(node.val)

        if node.left:
            queue.append((node_dist-1, node.left))
            # print(node.left.val)
        if node.right:
            queue.append((node_dist+1, node.right))
            # print(node.right.val)

    for distance, nodes in sorted(dist_dict.items()):
        res.append(nodes)

    return res

# if smae position, sort from small to big
#  record coordinate using extray array (x, y, node.val)
def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
    queue = collections.deque()
    queue.append((root, 0, 0))  # order does not matter, node, x, y
    arr = list()   # x, y, node.val
    while queue:
        node, x, y = queue.popleft()
        arr.append((x, y, node.val))
        if node.left:
            queue.append((node.left, x - 1, y + 1))
        if node.right:
            queue.append((node.right, x + 1, y + 1))

    arr.sort()

    res = [[arr[0][2]]]
    for i in range(1, len(arr)):
        if arr[i][0] == arr[i - 1][0]:  # smae distance in []
            res[-1].append(arr[i][2])
        else:
            res.append([arr[i][2]])
    return res
