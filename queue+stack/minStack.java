public class minStack{
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public minStack(){
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public void push(int number){
		stack.push(number);
		if(minStack.empty())
			minStack.push(number);
		else
			if(minStack.peek() >= number)
				minStack.push(number);
	}
	public int pop(){
		if(stack.peek().equals(minStack.peek()))
			minStack.pop();
		return stack.pop();
	}
	public int top(){
		retrun stack.top();
	}
	public int min(){
		return minStack.pop();
	}
}

stack: empty(), peek(), pop(), push();
queue: isEmpty(), peek(), poll(), offer();