private static final char[] ps = new char[]{'(',')','[',']','{','}'};
public List<String> validParenthesesII(int l, int m, int n){
  int[] remain = new int[]{l,l,m,m,n,n};
  int targetlen = 2*(m+l+n);
  StringBuilder path = new StringBuilder();
  Deque<Character> stack = new LinkedList<>();
  List<String> res = new ArrayList<>();
  dfs(path, stack, remain, targetlen, res);
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
          path.append(ps[i]);
          stack.offerFirst(ps[i]);
          remain[i]--;

          dfs(path, stack, remain, targetlen, res);

          path.deleteCharAt(path.length()-1);
          stack.pollFirst();
          remain[i]++;
        }
      }else{ //ready for right
        if(!stack.isEmpty() && stack.peekFirst() == ps[i-1]){
          path.append(ps[i]);
          stack.pollFirst();
          remain[i]--;

          dfs(path, stack, remain, targetlen, res);

          path.deleteCharAt(path.length()-1);
          stack.offerFirst(ps[i-1]);
          remain[i]++;
        }
      }
    }
  }
}
