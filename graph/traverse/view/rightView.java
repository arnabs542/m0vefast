//right to left, level order
public List<TreeNode> rightView(TreeNode root){
   List<Integer> result = new ArrayList<Integer>();
   if(root == null)
    return result;

   Queue<TreeNode> queue = new LinkedList<>();
   queue.add(root);
   //On each level of the tree, we add the right-most element to the results.
   while(!queue.isEmpty()){
       //get size here
       int size = queue.size();  //each level's size 
       //each level, use a for loop but only get the first one of the each loop
       for(int i=0; i<size; i++){
           TreeNode top = queue.poll();
           //the first element in the queue (right-most of the tree)
           if(i == 0){
               result.add(top.val);
           }
           //add right first
           if(top.right != null){
               queue.offer(top.right);
           }
           //add left
           if(top.left != null){
               queue.offer(top.left);
           }
       }
   }

   return res;
}
