http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/

// Function creates buf[] to store individual output string 
//and uses printHelper() to print all permutation
public void allPermutation(String str){
    int len = str.length();

        // Buffer to hold the string containing spaces
        // 2n-1 characters and 1 string terminator
    char[] buf = new char[2*len];

   // Copy the first character as it is, since it will be always
        // at first position
    buf[0] = str.charAt(0);
    printHelper(str, buf, 1, 1, len);
}

// Function recursively prints the strings having space pattern
// i and j are indices in 'String str' and 'buf[]'
private void printHelper(String str, char buf[], int i, int j, int n){
        if(i == n){
            buf[j] = '\0';
            System.out.println(buf);
            return;
        }

        // Either put the character
        buf[j] = str.charAt(i);
        printHelper(str, buf, i+1, j+1, n);
    }

        // Or put a space followed by next character
        buf[j] = ' ';
        buf[j+1] = str.charAt(i);
        printHelper(str, buf, i+1, j+2, n);
    }

http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value = value;
    }
}
public class Solution{
    public boolean isCousin(TreeNode root, TreeNode left, TreeNode right){
        return (level(root, a, 1) == level(root, b, 1)) 
        && (!isSibling(root, a, b));
    }
    //find level of child in a binary tree
    private int level(TreeNode root, TreeNode child, int level){
        if(root == null){
            return 0;
        }
        if(root == child){
            return level;
        }
        int lev = level(root.left, child, level+1);
        if(lev != 0){
            return lev;
        }
        return level(root.right, child, level+1);
    }
    //check if 2 nodes are siblings
    public boolean isSibling(TreeNode root, TreeNode left, TreeNode right){
        if(node == null){
            return false;
        }
        return (root.left == left && root.right == right)
        ||(root.left == that && root.right == left)
        ||isSibling(root.left, left, right)
        ||isSibling(root.right, left, right);
    }
}


http://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
public int getCut(int n){
    int m[] = new int[n + 1];
    //base case
    m[0] = 0;
    m[1] = 1;
    m[2] = 2;
    m[3] = 3;
    //recursive rule:
    for(int i = 4; i <= n; i++){
        //max value is i, since i = 1*1+1*1+....
        m[i] = i;
        //for all smaller numbers, recursivley find the min
        for(int j = 1; j <= i; j++){
            int temp = j*j;
            if(i > temp){
                break;
            }else{
                m[i] = Math.min(m[i], m[i - temp] + 1);
            }
        }
    }
    int res = m[n];
    return res;
}

http://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/

public List<String> formCircle(String input[]){
        List<String> result = new ArrayList<String>();
        //since chain is a circle any point can be the start point of the chain.
        //We make input[0] as start point
        result.add(input[0]);
        boolean used[] = new boolean[input.length];
        boolean r = formCircle(input,result,used,input[0].charAt(0));
        if(!r){
            return Collections.emptyList();
        }
        return result;
    }
    
    //we keep track of first char of the chain and the end compare that with last char of last element of the chain
    private boolean formCircle(String input[], List<String> result,boolean used[],char firstChar){
        if(input.length == result.size()){
            String str = result.get(result.size()-1);
            if(firstChar == str.charAt(str.length()-1)){
                return true;
            }
            return false;
        }
        String str = result.get(result.size()-1);
        char lastChar = str.charAt(str.length()-1);
        for(int i=1; i < input.length; i++){
            if(used[i]){
                continue;
         
            }
            if(lastChar == input[i].charAt(0)){
                used[i] = true;
                result.add(input[i]);
                boolean r = formCircle(input,result,used,firstChar);
                if(r){
                    return true;
                }
                used[i] = false;
                result.remove(result.size()-1);
            }
            
        }
        return false;
    }