//input = {"aaa", "bbb", "baa", "aab"}, return true since it can be re-arranged to {"aaa", "aab", "bbb"  and "baa"}
public boolean formRing(String[] input) {
    boolean[] res = new boolean[]{false};
    return dfs(input, 0, res);
}
private boolean dfs(String[] input, int startIndex, boolean[] res){
  if(startIndex == input.length){
    return input[startIndex-1].charAt(input[startIndex-1].length()-1) == input[0].charAt(0);
  }
  for(int i = startIndex; i < input.length; i++){
    if(startIndex == 0 || input[i].charAt(0) == input[startIndex-1].charAt(input[startIndex-1].length()-1)){
      swap(input, startIndex, i);
      if (dfs(input, startIndex+1, res)){
        return true;
      }
      swap(input, startIndex, i);
    }
  }
  return false;
}
private void swap(String[] input, int left, int right){
  String temp = input[left];
  input[left] = input[right];
  input[right] = temp;
}

第一 为什么index 要从 0开始呢？:因为我们第一个string就有可能选择不同的，这里没有跳过吧？

第二个swap，我们每次换过去的string就不会重复使用了，所以不会存在只有两个string一直重复的情况
public boolean formRing(String[] input) {
   boolean[] res = new boolean[1];
   for(int i = 0; i< input.length; i++){

     Stack<String> stack = new Stack<>();
     stack.push(input[i]);
     Set<Integer> set = new HashSet<>();
     set.add(i);

     dfs(input, stack, res, input[i], set);

     if(res[0]){
       return true;
     }
   }
   return false;
  }
  private void dfs(String[] input, Stack<String> stack, boolean[] res, String cur, Set<Integer>set){
    if(stack.size() == input.length){
      res[0] = isConnected(stack.peek(), cur);
      return;
    }
    for(int j = 0; j < input.length; j++){
      if(!set.contains(j) && isConnected(stack.peek(), input[j])){
        set.add(j);
        stack.push(input[j]);
        dfs(input, stack, res, cur, set);
        set.remove(j);
        stack.pop();
      }
    }
  }
  private boolean isConnected(String s1, String s2){
    return s1.charAt(s1.length()-1) == s2.charAt(0);
  }
