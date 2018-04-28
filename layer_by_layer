public List<List<Integer>> layerByLayer(TreeNode root) {
  List<List<Integer>> res = new ArrayList<List<>>();
  if(root == null) return res;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);
  while(!queue.isEmpty()){
    int size = queue.size();
    for(int i = 0 i < size; i++){
      TreeNode cur = queue.poll();
      curLayer.add(cur.key);
      List<Integer> curLayer = new ArrayList<>();
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
