public int cloest(TreeNode root, int target){
  int res = root.key;
  while(root != null){
    if(root.key == target){
      return root.key;
    }else{
      //update min_diff if necessary
      if(Math.abs(root.key - target) < Math.abs(res - target)){
        res = root.key;
      }
      //move cur pointer node 
      if(root.key < target){
        root = root.right;
      }else{
        root = root.left;
      }
    }
  }
  return res;
}
