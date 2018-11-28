public boolean backspaceCompare(String S, String T) {
  return build(S).equals(build(T));
}
private String build(String str){

  Stack<Character> stack = new Stack<>();
  for(char cur : str.toCharArray()){
    if(cur != '#')
      stack.push(cur);
      // cur = #
    else if(!stack.isEmpty())
      stack.pop();
  }
  return String.valueOf(stack);
}
