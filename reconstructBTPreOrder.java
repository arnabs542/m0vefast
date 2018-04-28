//assume: no duplicate, in and pre are not null
public TreeNode reconstruct(int[] in, int[] pre){
  //<node.value, nodeindex in in[]>
  Map<Integer, Integer> inIndex = new HashMap<>();
  for(int i = 0; i < in.length; i++){
    map.put(in[i], i);
  }
  return helper(pre, inIndex, 0, in.length-1, 0, pre.length-1);
}

private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex,
                        int inLeft, int inRight,
                        int preLeft, int preRight){
  if(inLeft > inRight){
    return null;
  }
  //get the root
  TreeNode root = new TreeNode(pre[preLeft]);
  //get the position of the root in inorder sequence,
  //so we know the size of the left/right tree
  int inMid = inIndex.get(root.key);
  root.left = helper(pre, inIndex,
                    inLeft, inMid-1,
                    preLeft+1, preLeft+inMid-inLeft);
  root.right = helper(pre, inIndex,
                    inMid+1, inRight,
                    preRight+1+inMid-inRight, preRight);
  return root;
}
