//LCA1
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  //base case
  if(root == null) return root;
  if(root == one || root == two) return root;
  //step 1
  TreeNode left = LCA(root.left, one, two);
  TreeNode right = LCA(root.right, one, two);
  //step2+3
  if(left != null && right !== null) return root;
  return left != null ? left : right;
}
//LCA_non-exist
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){

}
//LCA_p
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  int len1 = findLen(root, one);
  int len2 = findLen(root, two);
  int diff = 0;
  if (len1 >= len2){
    diff = len1 - len2;
  }
  while(diff > 0){
    len1--;
    one = one.parent;
  }
  while(one != two){
    one = one.parent;
    two = two.parent;
  }
  return one;
}
private int findLen(TreeNode root, TreeNode node){
  int len = 0;
  while(root != node){
    len++;
    node = node.parent;
  }
  return len;
}
//LCA_k_node
public TreeNode LCA(TreeNode root, List<TreeNodes> list){
  Set<TreeNode> set = new HashSet<>();
  for(TreeNode each : list){
    set.add(each);
  }
  return helper(root, set);
}
private TreeNode helper(TreeNode root, Set<TreeNode> set){
  if(root == null) return root;
  if(set.contains(root)) return root;
  //step 1
  TreeNode left = LCA(root.left, set);
  TreeNode right = LCA(root.right, set);
  //step2+3
  if(left != null && right !== null) return root;
  return left != null ? left : right;
}
//LCA_k_nary
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  //base case
  if(root == null) return root;
  if(root == one || root == two) return root;
  //step 1
  int counter = 0;
  TreeNode temp = null;
  for(TreeNode each : children){
    TreeNode node = helper(each, one, two);
    if(node != null){
      counter++;
      if(counter > 1) return root;
      temp = node;
    }
  }
  return temp;
}
//LCA_kk
public TreeNode LCA(TreeNode root, List<TreeNodes> list){
  Set<TreeNode> set = new HashSet<>();
  for(TreeNode each : list){
    set.add(each);
  }
  return helper(root, set);
}
private TreeNode helper(TreeNode root, Set<TreeNode> set){
  if(root == null) return root;
  if(set.contains(root)) return root;
  //step 1
  int counter = 0;
  TreeNode temp = null;
  for(TreeNode each : children){
    TreeNode node = helper(each, set);
    if(node != null){
      counter++;
      if(counter > 1) return root;
      temp = node;
    }
  }
  return temp;
}
//LCA_bst
public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
  if(root == null) return root;
  if(one.key < root.key && two.key < root.key){
    return LCA(root.left, one, two);
  }else if(one.key > root.key && two.key > root.key){
    return LCA(root.right, one, two);
  }else{
    return root;
  }
}
