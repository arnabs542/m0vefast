//Reverse this string in place
//iteravite:
public String reverseStr(String str){
  if(str == null || str.size() <= 1)
    return;
  char[] arr = str.toCharArray();
  for(int i = 0; i < arr.length; i++){
    swap(arr, i, arr.length-1-i);
  }
  return new String(arr);
}
//recursion
public String reverseStr(String str){
  char[] arr = str.toCharArray();
  helper(arr, 0, arr.length-1);
  return new String(arr);
}
private void helper(char[] arr, int left, int right){
  if(left >= right)
    return;
  while(left < right){
    swap(arr, left, right);
    helper(arr, i+1, j-1);
  }
}
//removing duplicate consecutive letters.
Q: remove dupliate1
public int[] duplicate1(int[] arr){
  if(arr == null || arr.length <= 1)
    return arr;
  int slow = 0;
  int fast;
  for(fast = 1; fast < arr.length; fast++){
    if(arr[slow] != arr[fast]){
      arr[++slow] = arr[fast];
    }
  }
  return Arrays.copyOf(arr, slow+1);
}
Q: remove dupliate0 override
public int[] duplicate0(int[] arr){
  if(arr == null || arr.length <= 1)
    return arr;
  int slow = 0;
  int fast;
  int flag = false;  //seen word on slow pointer
  for(fast = 1; fast < arr.length; fast++){
    if(arr[slow] == arr[fast]){
      flag = true;
    }else if(haveSeen){  //not equal but flag is true, slow is not stable now
      arr[slow] = arr[fast];   // previouly copy in the first if statement
      flag = false;
    }else{  //first time seen
      arr[++slow] = arr[fast];
    }
  }
  // previouly copy in the first if statement
  return flag ? Arrays.copyOf(arr, slow) : Arrays.copyOf(arr, slow+1);
}
Q: remove dupliate2
public int[] duplicate2(int[] arr){
  if(arr == null || arr.length <= 1)
    return arr;
  int slow = 0;
  int fast;
  int counter;
  for(fast = 1; fast < arr.length; fast++){
    if(arr[slow] != arr[fast]){
      arr[++slow] = arr[fast];
      counter = 1;
    }else if(counter < 2){  //equal
      arr[++slow] = arr[fast];
      counter++;
    }
  }
  return Arrays.copyOf(arr, slow+1);
}
Q: remove dupliate_zuma: stack
public int[] duplicate_zuma(int[] arr){
  if(arr == null || arr.length <= 1)
    return arr;
  int slow = 0; //index of final result, stack top: result index
  int fast = 1;
  for(fast = 1; fast < arr.length; fast++){
    if(arr[slow] != arr[fast] || slow == -1){
      arr[++slow] = arr[fast];
    }else{  //equal
      while(fast + 1 < arr.length && arr[fast] == arr[fast+1]){
        fast++;
      }
      slow--; // previouly copy in the first if statement
    }
  }
  return Arrays.copyOf(arr, slow+1);
}
//Reverse a double linked list
Q reverse linkedlist
public ListNode reverse(ListNode head){
  if(head == null || head.next == null)
    return head;
  ListNode next = head.next;
  ListNode newHead = reverse(next);
  newHead.next = head;
  head.next = null;
  return newHead;
}
public ListNode reverse(ListNode head){
  if(head == null)
    return head;
  ListNode next = head.next;
  head.next = head.prev;
  head.prev = next;
  //base case:
  if(head.prev == null)
    return head;
  reverse(next);
}
TODO:
//Write a function that gives you the greatest common factor of an array?
https://codereview.stackexchange.com/questions/166358/finding-the-greatest-common-factor-of-a-list-of-numbers-in-javascript
public int GCF(int[] arr){
  int res = arr[0];
  for(int i = 1; i < arr.length; i++){
    res = helper(res, arr[i]);
    if(res == 1)
      break;
  }
  return res;
}
public int helper(a, b){
  if (b == 0)
    return a;
  else
    return helper(b, a % b);
}
//If you had to design a microwave for college students, how would you start?
//system design question
//If you have 9 marbles and two uses of a balance scale, how do you figure out which marble is the heaviest?
Explain recursion to an 8 year old.

//String manipultion
Q i love tv
public String removeal(String str){
  if(str == null || str.size() == 0)
    return str;
  int fast = 0;
  int slow = 0;
  char[] arr = str,toCharArray();
  for(fast = 1; fast < arr.length; fast++){
    //copy but igfnore 2 cases
    if(arr[fast] != ' ' || (fast != 0 && arr[fast-1] != ' ')
      arr[slow++] = arr[fast];
  }
  return new String(arr, 0, slow);
}
Q remove e: set
public String removeCertainChar(String str, Character target){
  int fast = 0;
  int slow = 0;
  Set<Character> set = new HashSet<>();
  char[] arr = str.toCharArray();
  for(Character each : target.toCharArray()){
    set.add(each);
  }
  for(fast = 0; fast < arr.length; fast++){
     if(!set.contains(arr[fast]))
       arr[slow++] = arr[fast];
  }
  return new String(arr, 0, slow);
}
Q i love yahoo -> yahoo love
public String reverseWords(String str){
  if(str == " ")
    return ""; //otherwise out of boudn in 2nd if statmenet
char[] arr = str.toCharArray();
  int fast = 0;
  //int slow = 0;
  int start = 0;
  for(fast = 0; fast < arr.length; fast++){
    //find start
    if(arr[fast] != ' ' && (fast == 0 || arr[fast-1] == ' ')
      start = fast;
    if(arr[fast] != ' ' && (fast == arr.length-1 || arr[fast+1] == ' ')
      reverse(arr, start, fast);
  }
  reverse(arr, 0, arr.length-1);
  return new String(arr);
}
Q reverse vowal
public String reverseVowels(String str){
  //build set
  Set<Character> set = new HashSet<>();
  char[] arr = str.toCharArray();
  int left = 0;
  int right = arr.length-1;
  //each i teration, try to move one pointer
  while(left < right){
    if(!set.contains(arr[left]))
      left++;
      continue;
    if(!set.contians(arr[right]))
      right--;
      continue;
    else
      swap(arr, left, right);
  }
  return new String(arr);
}
Q replace
public String replace(String str, String a, String b){
  if(a.size() >= b.size())
    return replaceSorter(str, a, b);
  return replaceLonger(str, a, b);
}
private String replaceLonger(String str, String source, String target){
  char[] arr = str.toCharArray();
  List<Integer> matches = findMathcingEndIndex(arr, source);
  char[] res = new char[mathces.size() * (target.size() - source.size()) + str.size()];
  int slow = res.length;
  int fast = arr.length-1;
  int lastIndex = mathces.size()-1;
  while(fast >= 0){   //dont use for loop
    if(fast == lastIndex){
      copyStr(res, arr, lastIndex - soruce.size()+1);
      fast -= source.size();
      slow -= target.size();
      lastIndex--;
    }else{
      res[slow--] = arr[fast--];
    }
  }
  return new String(res);
}
private void copyStr(char[] a, String b, int start){
  for(Character each : b){
    a[start++] = each;
  }
}
private List<Integer> findMatchingEndingIndex(char[] arr, String source){
  List<Integer> res = new ArrayList<>();
  int startIndex = 0;
  while(startIndex < arr.length){
    if(isEqual(arr, startIndex, source))
      res.add(startIndex+ source.size() - 1);
      startIndex += source.size();
  }
  return res;
}
private boolean isEqual(char[] arr, int startIndex, String source){
  for(int i = 0; i  < source.size(); i++)
  {
    if(arr[i+startIndex] != srouce.charAt(i))
      return fasle;
  }
  return fasle;
}
private String replaceShorter(String str, String source, String target){

}
Q decode: recursion fb  3[a2[cb]]
public String decode(String str){
  int[] index = new int[]{0};  //current wroking index
  return helper(str, index);
}
private String helper(String str, int[] index){
  StringBuilder sb = new StringBuilder();
  //recursive function base case: 1) in range, 2) stop when reahing a ending bracket
  while(index[0] < str.size() && str.charAt(index[0]) == ']')
    Character cur = str.charAt(index[0]);
      //is digit
    if(Character.isDigit(cur)){
        counter = 0;
        while(Character.isDigit(arr[i])){
          counter = 10 * counter + (arr[i] - '0');
        }
        index[0]++; //for the following [
        String subStr = helper(str, index);
        index[0]++; //for the ending ]
        copyStr(sb, count, subStr);
    }else{   //is character, as a base case
      sb.append(cur);
      index[0]++;
    }
  }
  return sb.toString();
}
private void copyStr(StringBuilder sb, int count, String str){
  for(int i = 0; i < count; i++){
    sb.append(str);
  }
}
Q encode: incomplete
public String encode(String str){
  char fast = str.charAt(0);  //current char
  char slow = str.charAt(0);  //last char tobe record
  //char[] arr = str.toCharArray();
  int counter = 1;
  String res = "";
  for(int i = 1; str < arr.size(); i++){
    //append last round calculation
    fast = str.charAt(i);
    if(slow != fast){
      if(counter < 2){
        res += slow;
      }else{
        res += slow + counter;
      }
      counter = 1;  //first time seen current fast
    }else{   //1st char == 2nd char
      counter++;
    }
    slow = fast;
  }
  if(counter > 1){
    res += slow + counter;
  }else{
    res += slow;
  }
  return res;
}

Q abbr matching: recursion
public boolean abbrMatching(String source, String parttern){
  return helper(source, pattern, 0, 0);
}
private boolean helper(String source, String pattern, int s, int p){
  //recursion base case
  if(s == source.size() && p == pattern.size())
    return true;
  if(s > source.size() || p > pattern.size())
    return false;
  //if pattern p is isDigit
  if(Character.isDigit(pattern.charAt(p))){
    int counter = 0;
    while(Character.isDigit(pattern.charAt(p))){
      counter = counter * 10 + (pattern.charAt(p) - '0');
      p++;
    }
    return helper(source, pattern, s+counter, p);
  }else{//if pattern p is char
    if(pattern.charAt(p) == source.charAt(s)){
      return helper(source, pattern, s+1, p+1);
    }else{
      return false;
    }
  }
}

Q isMorphic
public boolean isMorphic(String a, String b){
  Map<Character, Character> map = new HashMap<>();
  for(int i = 0; i < a.size(); i++){
    Character ac = a.charAt(i);
    Character bc = b.charAt(i);
    if(map.contians(a)){
      if(map.get(a) != b){
        return false;
      }else{
        continue;
      }
    }else{
      if(map.continasValue(b)){
        return false;
      }else{
        map.put(a,b);
      }
    }
  return true;
  }

}
Q palindrome
public String isPalindrome(String str){
  char[] arr = str.toCharArray();
  for(int i = 0; i < arr.length/2; i}++){
    if(arr[i] != arr[arr.length-1-i])
      return false;
  }
  return true;
}
Q: substr
public boolean subStr(String big, String small){
  //check now, check lenghth comparison
  for(int i = 0; i <= big.size() - small.size(); i++){
    int j = 0;
    for(int j = 0; j < small.size(); j++){
      if(big.charAt(i+j) != small.charAt(j))
        break;
      if(j == small.size()-1)
        return true;
    }
    // if(j == small.length())
		// 	return i;
  }
  return false;
}
Q: shuffle: reverse engineer: ABCD1234 -> A1B2C3D4
public String shuffle(String str)
{
  return helper(helper(str, 0, str.size()-1));
}
private void helper(String str, int left, int right){
  int size = right - left + 1;
  if(size  < 2)
    return;
  int mid = left + (right - left)/2;
  int leftmid = left + mid/4;
  int rightmid = left + mid * 3 /4;
  reverse(str, leftmid, mid-1);
  reverse(str, mid, rightmid-1);
  reverse(str, leftmid, rightmid-1);
  helper(str, left, left+(leftmid - left)*2-1);
  helper(str, left + (leftmid-left)*2, rihgt);
}

//Valid sSudoku
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
public boolean validSudoku(char[][] grid){
  if(grid == null)
    return true;
  boolean[] visited = new boolean[grid.length];
  //for each row, check col validation
  for(int i = 0; i < 9; i++){
    Arrays.fill(visited, false);
    for(int j = 1; j < 9; j++){
      if(!isValid(visited, grid[i][j]))
        return false;
    }
  }
  //for each col, check row vlaidation
  for(int i = 0; i < 9; i++){
    Arrays.fill(visited, false);
    for(int j = 1; j < 9; j++){
      if(!isValid(visited, grid[j][i]))
        return false;
    }
  }
  //check submatrix
  for(int i = 0; i < 9; i+=3){
    for(int j = 0; j < 9; j+=3){
      Arrays.fill(visited, false);
      for(int k = 0; k < 9; k++){
        if(!isValid(visited, grid[k/3][k%3]))
          return false;
      }
  }
}
  return true;
}
private boolean isValid(boolean[] visited, char cur){
  if(cur == '.')
    return true;
  int toInt = cur - '0';
  if(toInt <= 0 || toInt > 9 || visited[toInt-1])
    return false;
  visited[toInt-1] = true;
  return true;
}


public TreeNode flatten(TreEeode root){
  if(root == null)
    return null;
  Stack<TreeNode> stack = new Stack<>();
  TreeNode cur = root;

  while(cur != null || !stack.isEmpty()){
    //save right
    if(cur.right != null){
      stack.push(cur.right);
    }
    //process left
    //1) if not reaching deepest left of current subtree
    if(cur.left != null)
    {
      cur.right = cur.left;
      cur.left = null;
    }else{  //2) if reachg deepest left of cur subtree
      TreeNode temp = stack.pop();
      cur.right = temp;
    }
    cur = cur.right;
    }
    return root;

  }

}
