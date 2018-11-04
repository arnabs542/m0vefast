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
  return true;
}
private boolean isValid(boolean[] visited, char cur){
  int toInt = cur - '0';
  if(toInt <= 0 || toInt > 9)
    return false;
  if(visited[])
    return false;
  visited[] = true;
  return true;
}
