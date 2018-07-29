//https://www.programcreek.com/2015/01/leetcode-verify-preorder-serialization-of-a-binary-tree-java/
// "9,3,4,#,#,1,#,#,2,#,6,#,#",
//We can keep removing the leaf node until there is no one to remove.
// If a sequence is like "4 # #", change it to "#" and continue.
//  We need a stack so that we can record previous removed nodes.
public boolean isValidPreOrderBT(String preorder) {
   // Write your solution here
   LinkedList<String> stack = new LinkedList<String>();
    String[] arr = preorder.split(",");

    for(int i=0; i<arr.length; i++){
        stack.add(arr[i]);

        while(stack.size()>=3
            && stack.get(stack.size()-1).equals("#")
            && stack.get(stack.size()-2).equals("#")
            && !stack.get(stack.size()-3).equals("#")){

            stack.remove(stack.size()-1);
            stack.remove(stack.size()-1);
            stack.remove(stack.size()-1);

            stack.add("#");
        }
    }

    if(stack.size()==1 && stack.get(0).equals("#"))
        return true;
    else
        return false;
 }
