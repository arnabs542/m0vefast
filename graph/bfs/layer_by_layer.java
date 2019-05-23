public List<List<Integer>> layerByLayer(TreeNode root) {
  List<List<Integer>> res = new ArrayList<List<>>();
  if(root == null)
    return res;
  Queue<TreeNode> queue = new LinkedList<>();
  //initialization
  queue.offer(root);
  //termination
  while(!queue.isEmpty()){
    int size = queue.size();
    //expand
    for(int i = 0 i < size; i++){
      TreeNode cur = queue.poll();
      List<Integer> curLayer = new ArrayList<>();
      curLayer.add(cur.key);
      //generate
      if(cur.left != null){
        queue.offer(left);
      }
      if(cur.right != null){
        queue.offer(right);
      }
    }
    res.add(curLayer);
  }
  return res;
}
