public TreeNode reconstruct(int[] in, int[] level){
  Map<Integer, Integer> map = new HashMap<>();
  for(int i = 0; i < in.length; i++){
    map.put(in[i], i);
  }
  List<Integer> levelList = new ArrayList<>();
  for(int num : level){
    levelList.add(num);
  }
  return helper(levelList, map);
}

private TreeNode helper(List<Integer> levelList, Map<Integer, Integer> map){
  if(levelList.isEmpty())
    return null;
  int root_value = levelList.get(0);
  TreeNode root = new TreeNode(root_value);
  List<Integer> left = new ArrayList<>();
  List<Integer> right = new ArrayList<>();
  for(int i = 1; i < levelList.size(); i++){
    int cur = levelList.get(i);
    if(map.get(cur) < map.get(root.key)){
      left.add(cur);
    }else{  //if in left subtree
      right.add(cur);
    }
  }
  root.left = helper(left, map);
  root.right = helper(right, map);
  return root;
}
