//Evaluate Reverse Polish Notation
//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
public int evalPRN(String[] arr){
  if(arr.length == 0)
    return 0;
  Deque<Integer> stack = new ArrayDeque<>();
  for(String s : arr){
    if(s.equals("+")){
      stack.push(stack.pop() + stack.pop());
    }else if(s.equals("-")){
      // int s1 = stack.pop();
      // int s2 = stack.pop();
      // stack.push(s2-s1);
      stack.push(stack.pop() - stack.pop());
    }else if(s.equals("*")){
      stack.push(stack.pop() * stack.pop());
    }else if(s.equals("/")){
      int num = stack.pop();
      stack.push(stack.pop/num);
    }else{
      stack.push(Integer.parseInt(s));
    }
  }
  //return stack.isEmpty() ? 0 : stack.peek();
  return stack.peek();
}
