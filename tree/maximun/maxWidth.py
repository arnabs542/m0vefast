'''
是这一层两端的节点在对应的满二叉树中的距离
如果一个节点的下标是 idx, 那么它的左子节点的下标就是 idx * 2, 它的右子节点的下标就是 idx * 2 + 1.
我们记录下每一层出现的最大的和最小的下标即可得到这一层的宽度

strategy:
- bfs using queue not deque
- (node, depth, position)
- update width at each level
'''
def maxWidth(root):
    if root is None:
        return 0
    queue = [(root, 0, 0)]
    width = depth = pos = 0

    for node, cur_depth, pos in queue:
        if node:
            queue.append((node.left, cur_depth+1, pos*2))
            queue.append((node.right, cur_depth+1, pos*2+1))
            if cur_depth != depth: # entering a new levels
                depth = cur_depth
                left = pos
            width = max(width, (pos - left) + 1)
    return width
