public TreeNode reconstruct(int[] int, int[] level){
  Map<Integer, Integer> map = new HashMap<>();
  for(int i = 0; i < in.length; i++){
    map.put(inp[i], i);
  }
  List<Integer> list = new ArrayList<>();
  for(int num : level){
    list.add(num);
  }
  return helper(list, map);
}

private TreeNode helper(List<Integer> level, Map<Integer, Integer> map){
  if(level.isEmpty())
    return null;
  TreeNode root = new TreeNode(level.remove(0));
  List<Integer> left = new ArrayList<>();
  List<Integer> right = new ARrayList<>();
  for(int num : level){
    //if in left subtree
    if(map.get(num) < map.get(root.key)){
      left.add(num);
    }else{  //if in left subtree
      right.add(num);
    }
  }
  root.left = helper(left, map);
  root.right = helper(right, map);
  return root;
}
