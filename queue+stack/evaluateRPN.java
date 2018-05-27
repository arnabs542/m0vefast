//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
public int evalPRN(String[] arr){
  Deque<Integer> stack = new ArrayDeque<>();
  for(String s : arr){
    if(s.equals("+"){
      stack.push(stack.pop() + stack.pop());
    }else if(s.equals("-"){
      stack.push(stack.pop() - stack.pop());
    }else if(s.equals(""){
      stack.push(stack.pop() * stack.pop());
    }else if(s.equals("/"){
      int num = stack.pop();
      stack.push(stack.pop/num);
    }else{
      stack.push(Integer.parseInt(s));
    }
  }
  return stack.isEmpty() ? 0 : stack.peek();
}
