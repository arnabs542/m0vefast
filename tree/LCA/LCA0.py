#LCA1   O(height)
def LCA(root, one, two):
    if root is None:
        return root
    if root is one or root is two:
        return root
    left = LCA(root.left, one, two)
    right = LCA(root.right, one, two)
    if left and right:
        return root
    else:
        return left is left else right

#LCA_non-exist
def non_LCA(root, one, two):
    return root
#LCA_p    O(n)
def LCA(root, one, two):
    if root is None:
        return root
    if root is one or root is two:
        return root
    one_dist = getLen(root, one)
    two_dist = getLen(root, two)
    if one_dist > two_dist:
        for i in range(one_dist - two_dist):
            one = one.parent
    else:
        for i in range(two_dist - one.dist):
            two = two.parent
    while one != two:
        one = one.parent
        two = two.parnet
    return one

def getLen(root, node):
    res = 0
    cur = node
    while cur != node
        res += 1
        cur = cur.parent
    return res

#LCA_k_node
def LCA_knode(root, knodes_set):
    if root is None:
        return root
    if root in knodes_set:
        return root
    left = LCA_knode(root.left, knodes_set)
    right = LCA_knode(root.right, knodes_set)
    if left and right:
        return root
    else
        return left if left else right

#LCA_k_nary
# node.children
# need to check more than 1 child return not null
def LCA_knary(root, one, two):
    if root is None:
        return root
    if root is one or root is two:
        return root
    temp = None
    counter = 0
    for child in root.children:
        node = LCA_knary(child, one, two)
            if node:
                counter += 1
                if counter == 1:
                    return root
            else:
                temp = node
    return temp

#LCA_kk
# think should be the same as above
def LCA_kk(root, knodes_set):
    if root is None:
        return root
    if root is in knodes_set:
        return root
    counter = 0
    temp = None
    for child in root.children:
        node = LCA_kk(child, knodes_set)
        if node:
            counter += 1
            if counter == 2:
                return root
            else:
                temp = node
    return temp

#LCA_bst
def LCA_bst(root, one, two):
    if root is None:
        return root
    if root.val < one.val and root.val < two.val:
        return LCA_bst(root.right, one, two)
    elif root.val > one.val and root.val > two.val:
        return LCA_bst(root.left, one, two)
    else:
        reutrn root
