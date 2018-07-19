private static final char[] input = new char[]{'(',')','[',']','{','}'};
public List<String> vaidParenthesis3(int l, int m, int n){
  int[] remain = new int[]{l,l,m,m,n,n};
  int targetlen = 2*(m+l+n);
  StringBuilder path = new StringBuilder();
  Deque<Character> stack = new LinkedList<>();  //to maintain palindrom
  List<String> res = new ArrayList<>();
  dfs(res, path, targetlen, remain, stack);
  return res;
}
private void dfs(StringBuilder path,
                  Deque<Character> stack,
                  int[] remain,
                  int targetlen,
                  List<String> res){
  if(path.length() == targetlen){
    res.add(path.toString());
    return;
  }else{
    for(int i = 0; i < remain.length; i++){
      //if on index 0,2,4... ready for left
      if(i % 2 == 0){
        if(remain[i] > 0){
          path.append(input[i]);
          stack.offerFirst(input[i]);
          remain[i]--;

          dfs(res, path, targetlen, remain, stack);

          path.deleteCharAt(path.length()-1);
          stack.pollFirst();
          remain[i]++;
        }
      }else{ //ready for right 1) has a left 2) last is a left bracket
        if(!stack.isEmpty() && stack.peekFirst() == input[i-1]){
          path.append(input[i]);
          stack.pollFirst();
          remain[i]--;

          dfs(res, path, targetlen, remain, stack);

          path.deleteCharAt(path.length()-1);
          stack.offerFirst(input[i-1]);
          remain[i]++;
        }
      }
    }
  }
}
