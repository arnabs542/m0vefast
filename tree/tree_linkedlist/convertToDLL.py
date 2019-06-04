'''
//一个简单的dfs，in order traverse this tree.
// 然后每次返回一个数组，第一位放head of sub tree, 第二位放tail of sub tree
// 然后注意双向链表的连接。 https://www.jianshu.com/p/f2eac0a35586
'''
# solution 2 inorder traversal, iterative version, using stack
def treeToCircularDLL(root):
    if root is None:
        return
    prev = head = None

    stack = []
    cur = root
    while cur and stack:
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()

        if not head: # update head if empty
            head = cur
        else:         # cur, subtree head
            prev.right = cur
            cur.left = prev
        prev = cur # update prev
        cur = cur.right  #update cur 

    head.left = prev  #circular
    prev.right = head
    return head



  public List<Integer> inOrderTraversal(TreeNode root){
  	Stack<TreeNode> stack = new Stack<TreeNode>();   //record for direction
  	List<Integer> res = new ArrayList<>();
  	TreeNode cur = root;
  	while(cur != null ||!stack.empty()){
  		//go till the very left
  		while(cur != null){
  			stack.push(cur);
  			cur = cur.left;
  		}
  		cur = stack.pop();
  		res.add(cur.value);
  		cur = cur.right;
  	}
  	return res;
  }
