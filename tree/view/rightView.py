# iterative O(n) level order, right to left
def rightSideView(root):
    if root is None:
        return
    queue = collections.deque([root])
    res = []
    while queue:
        for index in range(len(queue)):
            top = queue.popleft()
            if index == 0:
                res.append(top.value)
            if top.right:
                queue.append(top.left)
            if top.left:
                queue.append(top.right)
    return res

def rightsideView(root):
    view = []
    if root:
        level = [root]
        while level:
            view += level[-1].value,  # for each level, only add the rightmost child
            level = [child for node in level for child in (node.left, node.right) if child]
            # for child(node.left, node.right) of all nodes on this level
    return res



# recursion: O(n)
def rightsideView(root):

#
#
# Solution 2: Recursive, first come first serve: 9 lines, 48 ms
#
# DFS-traverse the tree right-to-left, add values to the view whenever we first reach a new record depth. This is O(n).
#
# def rightSideView(self, root):
#     def collect(node, depth):
#         if node:
#             if depth == len(view):
#                 view.append(node.val)
#             collect(node.right, depth+1)
#             collect(node.left, depth+1)
#     view = []
#     collect(root, 0)
#     return view
