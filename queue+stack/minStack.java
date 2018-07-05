public class minStack{
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public minStack(){
		stack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
	}
	public void push(int number){
		stack.push(number);
		if(minStack.empty() || minStack.peek() >= number)
			minStack.push(number);
	}
	public int pop(){
		if(stack.isEmpty())
    	return -1;
    int res = stack.poll();
    if(minStack.peek().equals(res)){
      minStack.poll();
    }
    return res;
	}
	public int top(){
		if(stack.isEmpty())
    	return -1;
		return stack.peek();
	}
	public int min(){
		if(minStack.isEmpty())
   	 return -1;
		return minStack.peek();
	}
}

stack: empty(), peek(), pop(), push();
queue: isEmpty(), peek(), poll(), offer();
