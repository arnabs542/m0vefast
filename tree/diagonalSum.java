//topview, vertical traversal
public List<Integer> diagonalSum(TreeNode root) {
   // Write your solution here
   List<Integer> res = new ArrayList<>();
   Queue<TreeNode> queue = new LinkedList<>();
   //sum of node's data lying diagonally <distance, sum>
   Map<Integer, Integer> map = new TreeMap<>();
   root.dist = 0;
   queue.add(root);
   while(!queue.isEmpty()){
      TreeNode cur = queue.poll();
      int distance = cur.dist;
      // Sum over this node's right-child, right-of-right-child and so on
      while(cur != null){
        int preSum = map.get(distance) == null ? 0 : map.get(distance);
        map.put(distance, preSum + cur.data);
        //if for any node theleft child is not null, add it to the queue
        //every left node starts a new diagnoal, further distance from the root
        if(cur.left != null){
          cur.left.dist = distance+1;   //left child distance is ancestor's distance + 1 (draw it !!!!)
          queue.add(cur.left);
        }
        //move tot eh cur node's right child;
        cur = cur.right;
      }
   }
   Set<Entry<Integer, Integer>> set = map.entrySet();
   Iterator<Entry<Integer, Integer>> itr = set.iterator();
   while(itr.hasNext()){
     Map.Entry<Integer, Integer> next = itr.next();
     res.add(next.getValue());
   }
   return res;
}



 // The idea is to keep track of vertical distance from top diagonal passing through root. We increment the vertical distance we go down to next diagonal.
 // 1. Add root with vertical distance as 0 to the queue.
 // 2. Process the sum of all right child and right of right child and so on.
 // 3. Add left child current node into the queue for later processing. The vertical distance of left child is vertical distance of current node plus 1.
 // 4. Keep doing 2nd, 3rd and 4th step till the queue is empty.
