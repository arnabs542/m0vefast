//2 nodes not in correct position, recover the Tree
//O(n), O(LogN)
http://blog.sina.com.cn/s/blog_eb52001d0102v1z3.html
Wrong order: 1 3 8 6 7 4 10 13 14
FIND:            8 6
Then we find:        7 4
            swap 8 and 4
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
