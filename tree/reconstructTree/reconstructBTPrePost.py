def constructFromPrePost(self, pre, post):
    if not pre:
        return None
    root_value = pre[0]
    root = TreeNode(root_value)
    if len(pre) == 1:
        return root

    left_size = post.index(pre[1]) + 1
    root.left = self.constructFromPrePost(pre[1:left_size+1], post[:left_size])
    root.right = self.constructFromPrePost(pre[left_size+1:], post[left_size:-1])
    return root

    # if not preorder or postorder or preorder[0] not in postorder:
    #     return None
    #
    # root_value = preorder.pop(0)
    # root = TreeNode(root_value)
    # root_index = postorder.index(root_value)
    # print(preorder, postorder[:root_index])
    # root.left = reconstructBTPrePost(preorder, postorder[:root_index])
    # print(preorder, postorder[:root_index])
    # root.left = reconstructBTPrePost(preorder, postorder[:root_index])
    # #print(preorder, postorder[:root_index])
    # return root

'''
either no elements left in pre list
no elements in post list
if top element of pre doesnt occur in post
'''


class Solution(object):


if __name__ == '__main__':
    preorder = [1,2,4,5,3,6,7]
    postorder = [4,5,2,6,7,3,1]
    reconstructBTPrePost(preorder, postorder)
