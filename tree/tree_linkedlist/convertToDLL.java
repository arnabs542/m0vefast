//一个简单的dfs，in order traverse this tree.
// 然后每次返回一个数组，第一位放head of sub tree, 第二位放tail of sub tree
// 然后注意双向链表的连接。 https://www.jianshu.com/p/f2eac0a35586
public TreeNode toDoubleLinkedList(TreeNode root) {
    // Write your solution here.
        if (root == null)
            return null;
        return dfs(root)[0];
    }
// use leftChild as "prev"
// use rightChild as "next
private TreeNode[] dfs(TreeNode root) {
    if (root == null)
        return null;
    TreeNode head = null;
    TreeNode tail = null;
    TreeNode[] left = dfs(root.left);
    if (left != null) {
        head = left[0];

        left[1].right = root;
        root.left = left[1];
    }
    TreeNode[] right = dfs(root.right);
    if (right != null) {
        root.right = right[0];
        right[0].left = root;

        tail = right[1];
    }
    TreeNode[] ret = new TreeNode[2];
    ret[0] = (head == null ? root : head);
    ret[1] = (tail == null ? root : tail);
    return ret;
}

//recursive
// 时间上是O(n)的，因为要过每一个node
// 空间上，你可以记录一个prev node，这样空间是O(height)的
TreeNode head;
static TreeNode prev = null;  //the same value is accessible in all recursive calls
public ListNode toDoubleLinkedList(TreeNode root){
  if(root == null)
    return root;
  toDoubleLinkedList(root.left);
  if(prev == null)
    head = root;
  else{
    root.left = prev;
    prev.right = root;
  }
  prev = root;
  toDoubleLinkedList(root.right);
  return root;
}

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
