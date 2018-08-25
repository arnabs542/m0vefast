//{"0","12","4","+","-"} -> -16
//"+", "-", "", "/"   //siffix experresion
//https://piazza.com/class/j0eqhhdregb3i?cid=2946
//http://interactivepython.org/runestone/static/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html
public int evalPostfixExpression(String[] arr) {
  if(arr.length == 0)
    return 0;
  Deque<Integer> stack = new ArrayDeque<>();
  for(String s : arr){
    if(s.equals("+")){
      stack.push(stack.pop() + stack.pop());
    }else if(s.equals("-")){
      int s1 = stack.pop();
      int s2 = stack.pop();
      stack.push(s2-s1);
      //stack.push(stack.pop() - stack.pop());
    }else if(s.equals("")){
      stack.push(stack.pop() * stack.pop());
    }else if(s.equals("/")){
      int num = stack.pop();
      stack.push(stack.pop() / num);
    }else{
      stack.push(Integer.parseInt(s));
    }
  }
  //return stack.isEmpty() ? 0 : stack.peek();
  return stack.peek();
}
