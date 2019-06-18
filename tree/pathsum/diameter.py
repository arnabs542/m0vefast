# diameter: longest path from left to left
'''
diameter: A longest path or route between any two leaf nodes in a tree. The path may or may not for through the root.
Return max of following three
1) Diameter of left subtree
2) Diameter of right subtree
3) the longest path between leaves that goes through the root: height of the root: leftheight + rightheight + 1  */
# notice return length not the height
'''
def diameter(root):
    if root is None:
        return 0
    self.diameter = 0
    self.height(root)
    return self.diameter

def height(root):
    if root is None:
        return 0
    left = height(root.left)
    right = height(root.right)
    self.diameter = max(self.diameter, left+right)
    return 1 + max(left, right)
