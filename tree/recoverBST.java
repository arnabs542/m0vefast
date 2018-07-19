//2 nodes not in correct position, recover the Tree
//O(n), O(LogN)
http://blog.sina.com.cn/s/blog_eb52001d0102v1z3.html
例如1,4,3,2,5,6
1.当我们读到4的时候，发现是正序的，不做处理
2.但是遇到3时，发现逆序，将4存为第一个错误节点，3存为第二个错误节点
3.继续往后，发现3，2又是逆序了，那么将第2个错误节点更新为2
如果是这样的序列：1,4,3,5,6同上，得到逆序的两个节点为4和3。
Wrong order: 1 3 8 6 7 4 10 13 14
FIND:            8 6
Then we find:        7 4
            swap 8 and 4
8, 6 是错误的序列, 但是，7，4也是错误的序列。
因为8，6前面的序列是正确的，所以8，6一定是后面的序列交换来的。
而后面的是比较大的数字，也就是说8一定是被交换过来的。而7，4
中也应该是小的数字4是前面交换过来的
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    //in order traversal, should be ascending
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
         //8: make sure the first occurance of not decending, first wrong order
        if (firstElement == null && root.val < lastElement.val) {
            firstElement = lastElement;
        }
        // the rest that are not assending, alwasy updating th elast one
        if (firstElement != null && root.val < lastElement.val) {
            secondElement = root;
        }
        lastElement = root;
        traverse(root.right);
    }

    public void recoverTree(TreeNode root) {
        // in order traverse and get two elements
        traverse(root);
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
