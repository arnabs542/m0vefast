https://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
//find the longest palindrome bracket,Given a string containing just the characters '(' and ')',
//O(n) O(n)
//Special thing is that trick of using i(index) and 0|1 for extra ')', to cover this kind of testcases: ())()() :Sol is 4.  ())()( ->6
public int longestValidParentheses(String s){
  Stack<int[]> stack = new Stack<int[]>();
	int result = 0;

	for(int i = 0; i < s.length(); i++){
		char c = s.charAt(i);
		if(c == '('){ //this is a left bracket
			int[] index = {i, 0};  //0 for left bracket  {index, leftOrRightBracket}
			stack.push(index);
		}else{  //this is a right bracket
			if(stack.empty() || stack.peek()[1] == 1){ //...)
				int[] index = {i, 1};   //1 for right bracket
				stack.push(index);
			}else{    //...()
				stack.pop();  //this will pop up all existing palindrome
				int currentLen = 0;
				if(stack.empty()){
					currentLen = i + 1;  //0 index based
				}else{
					currentLen = i-stack.peek()[0];
				}
        //only update when finds a palindrome
				result = Math.max(result, currentLen);
			}
		}

	}
	return result;
}
