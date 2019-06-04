//lai solution using deque
public List<Integer> zigZag(TreeNode root) {
    if(root == null)
        return new LinkedList<Integer>();

    Deque<TreeNode> deque = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    deque.offerLast(root);
    int layer = 0;

    while(!deque.isEmpty()){
        //the size is changing, size of each level
        int size = deque.size();
        for(int i = 0; i < size; i++){
            if(layer == 0){  //even level, right->left
                TreeNode temp = deque.pollLast();
                list.add(temp.key);
                if(temp.right != null)
                    deque.offerFirst(temp.right);
                if(temp.left != null)
                    deque.offerFirst(temp.left);
            }else{ //odd level, left->right
                TreeNode temp = deque.pollFirst();
                list.add(temp.key);
                if(temp.left != null)
                    deque.offerLast(temp.left);
                if(temp.right != null)
                    deque.offerLast(temp.right);
            }
        }
        layer = 1 - layer;
    }
    return list;
}
//the other solution j
public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    if(root == null)
        return res;

    Stack<TreeNode> curLevel = new Stack<TreeNode>();
    Stack<TreeNode> nextLevel = new Stack<TreeNode>();
    Stack<TreeNode> temp = new Stack<TreeNode>();

    curLevel.push(root);
    boolean normalOrder = true;

    while(!curLevel.isEmpty()){
        ArrayList<Integer> curLevelRes = new ArrayList<>();
        while(!curLevel.isEmpty()){
            TreeNode node = curLevel.pop();
            curLevelRes.add(node.val);
            if(normalOrder){
                if(node.left != null)
                    nextLevel.push(node.left);
                if(node.roght != null)
                    nextLevel.push(node.right);
            }else{
                if(node.right != null)
                    nextLevel.push(node.right);
                if(node.left != null)
                    nextLevel.push(node.left);
            }
        }
        res.add(curLevelRes);
        temp = curLevel;
        curLevel = nextLevel;
        nextLevel = temp;
        normalOrder = !normalOrder;
    }
    return res;
}
