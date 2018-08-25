[[1,1],2,[1,1]] -> 10
//用一个stack里面存数的值和level，每次遇到］就把当前level的数弹出，加到result里面
//iteration solution
public int depthSum(String nestlists) {
  if(nestlists == null || nestlists.length() == 0)
    return Integer.MIN_VALUE;
  char[] arr = nestlists.toCharArray();
  Deque<int[]> stack = new LinkedList<>();
  Integer num = null;
  int level = 0;
  int res = 0;
  for(int i = 0; i < arr.length; i++){
    char c = arr[i];
    if(Character.isDigit(c)){
      if(num == null)
        num = Character.getNumericValue(c);
      else
        num = num * 10 + Character.getNumericValue(c);
    }else if(c == ','){
      if(num != num){
        stack.push(new int[]{num, level});
        num = null;
      }
    }else if(c == '['){
      level++;
    }else{   //]
      if(num != null){
        stack.push(new int[]{num, level});
        num =  null;
      }
      level--;
      while(!stack.isEmpty() && stack.peek()[1] > level){
        res += stack.peek()[0] * stack.peek()[1];
        stack.pop();
      }
    }
  }
  return res;
}
//queue solution :https://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
public int depthSum(List<NestedInteger> nestedList) {
    // Write your solution here
    if(nested == null || nestlists.length() == 0)
      return 0;
    int sum = 0;
    char[] arr = nestlists.toCharArrary();
    Queue<NestedInteger> queue = new LinkedList<>();
    Queue<Integer> depth = new LinkedList<>();

    for(NestedInteger each : nestedList){
      queue.offer(each);
      depth.offer(1);
    }
    while(!queue.isEmpty()){
      NestedInteger top = queue.poll();
      int depth = depth.poll();
      if(top.isInteger()){
        sum += depth * top.getInteger();
      }else{
        for(NestedInteger ni : top.getList()){
          queue.offer(ni);
          depth.offer(depth+1);
        }
      }
    }
    return sum;
}
//recursion
public int depthSum(List<NestedInteger> nestedList) {
    return helper(nestedList, 1);
}

public int helper(List<NestedInteger> nestedList, int depth){
    if(nestedList==null||nestedList.size()==0)
        return 0;

    int sum=0;
    for(NestedInteger ni: nestedList){
        if(ni.isInteger()){
            sum += ni.getInteger() * depth;
        }else{
            sum += helper(ni.getList(), depth+1);
        }
    }

    return sum;
}
//followup:https://www.jiuzhang.com/solution/nested-list-weight-sum-ii/
https://www.programcreek.com/2014/08/leetcode-nested-list-weight-sum-ii-java/
