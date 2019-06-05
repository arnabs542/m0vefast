public TreeNode reconstruct(int[] in, int[] post) {
    // Write your solution here
    Map<Integer, Integer> map = new HashMap<>();
  for(int i = 0; i < in.length; i++){
    map.put(in[i], i);
  }
  return helper(post, map, 0, in.length-1, 0, post.length-1);
}

private TreeNode helper(int[] postorder, Map<Integer, Integer> inIndex,
                               int inLeft, int inRight,
                               int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postRight]);
        //leftSize = inMid-inLeft
        int inMid = inIndex.get(root.key);
        root.left = helper(postorder, inIndex,
                          inLeft, inMid - 1,
                          postLeft, postLeft + inMid - inLeft - 1);
        root.right = helper(postorder, inIndex,
                          inMid + 1, inRight,
                          postLeft + inMid - inLeft, postRight - 1);
        return root;
    }
