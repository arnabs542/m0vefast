# followup; O(n), O(height)
'''
对于一个搜索二叉树的前序序列来说, 如果某段序列为一个递减序列, 说明这是一段沿着左子树的路径. [all put on stack]
直到碰到一个比前一个大的值, 说明此时已经来到某个结点的右子树上了, 而此时可以得出一个此后序列的下界值, [the last one stack that are smaller than cur node]
也就是此后序列的任意一个值必须要比这个结点的父结点的值大[3>2, 父节点is 2=lower; 6>5], 因为对于搜索二叉树来说根节点左边的都比根节点小,
而根节点右边的都比根节点大, 所以既然现在已经来到某个结点(设为A)的右子树上, 那么此后任何结点的值必然比A的值大. 
'''
def verifyPreorderBST(preorder):
    if root is None:
        return False
    stack = []  # stack top as the father of the next node

    for node in preprder:
        if node < lower:
            return False

        # meet right side of a subtree
        while stack and node > stack[-1]:
            lower = stack.pop()
        stack.append(node)

    return True
