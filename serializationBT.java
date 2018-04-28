//serialization
//covert bt to doubly linkedlist in in-order sequence

//keep tracking head and pre ptr
public static TreeNode prev = null;
public void convert(TreeNode root, TreeNode head){
  if(root == null)
    return;
  convert(root.left, head);
  if(prev == null){
    head = root;
  }else{
    root.left = prev;
    prev.right = root
  }
  prev = root;
  convert(root.right, head);
}
