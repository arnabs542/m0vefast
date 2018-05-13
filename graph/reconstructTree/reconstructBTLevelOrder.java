public TreeNode reconstruct(int[] in, int[] level){
  Map<Integer, Integer> map = new HashMap<>();
  for(int i = 0; i < in.length; i++){
    map.put(in[i], i);
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
  int root_value = level.get(0);
  TreeNode root = new TreeNode(root_value);
  List<Integer> left = new ArrayList<>();
  List<Integer> right = new ARrayList<>();
  for(int i = 1; i < level.size(); i++){
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
