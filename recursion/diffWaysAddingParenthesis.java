Map<String, List<Integer>> map = new HashMap<>(); //来存储以前计算过的值，跟滑雪一样属于memorization
public List<Integer> diffWaysToCompute(String input) {
    List<Integer> res = new ArrayList<>();
    if (input == null || input.length() == 0)
      return res;
    //base case1
    if (map.containsKey(input))
      return map.get(input);
    //recursion rule
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '+' || c == '-' || c == '*') {
            List<Integer> leftNums = diffWaysToCompute(input.substring(0, i));
            List<Integer> rightNums = diffWaysToCompute(input.substring(i + 1));
            for (int left : leftNums) {
                for (int right : rightNums) {
                    if (c == '+')
                      res.add(left + right);
                    else if (c == '-')
                      res.add(left - right);
                    else if (c == '*')
                      res.add(left * right);
                }
            }
        }
    }
    //base cases2
    if (res.size() == 0)
      res.add(Integer.parseInt(input));
    map.put(input, res);
    return Collections.sort(res);;
}
Time Complexity - O(2n)， Space Complexity - O(2n)
divid and conquer
忽略运算符的优先级来计算算式。在算式valid的条件下，只要遇到运算符，我们就计算出左侧的数和右侧的数，
然后根据这个运算符来得到结果。
 我们需要先递归计算运算符左半边的结果，和运算符右半边的结果，然后使用双重循环，根据运算符来把最终结果加入到结果集res中去。要注意的是递归到最后，
 我们的base case是没有运算符，只有数字的时候， 这时我们可以直接把这个数加入到结果集里。时间复杂度应该是catalan number，空间复杂度也是指数级。
 "2-1-1".
 ((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]
"2*3-4*5"
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
这里很像Unique Binary Search Tree II
https://www.cnblogs.com/yrbbest/p/5006196.html
https://www.geeksforgeeks.org/all-ways-to-add-parenthesis-for-evaluation/
