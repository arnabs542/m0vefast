//private static final char[] ps = new char[]{'(',')','[',']','{','}'};
https://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
public boolean vaidParenthesis2(String s){
  HashMap<Character, Character> map = new HashMap<Character, Character>();
	map.put('(', ')');
	map.put('[', ']');
	map.put('{', '}');

	Stack<Character> stack = new Stack<Character>();

	for (int i = 0; i < s.length(); i++) {
		char curr = s.charAt(i);
    //this is left bracet
		if (map.keySet().contains(curr)) {
			stack.push(curr);
    //this is right bracet
		} else if (map.values().contains(curr)) {
			if (!stack.empty() && map.get(stack.peek()) == curr) {
				stack.pop();
			} else {
				return false;
			}
		}
	}
	return stack.empty();
}
