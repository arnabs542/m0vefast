[[1,1],2,[1,1]] -> 10
//iteration solution
public int depthSum(String nestlists) {
  if(nestlists == null || nestlists.length() == 0)
    return Integer.MIN_VALUE;
  char[] arr = nestlists.toCharArrary();
  int mul = 0;
  int res = 0;
  for(int k = arr.length-1; k >= 0; k--){
    if(arr[k] == ']')
      mul++;
    else if(arr[k] == '[')
      mul--;
    else if(Character.isDigit(arr[k]))
      res += mul * (arr[k] - '0')
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
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> depth = new LinkedList<>();

    for(NestedInteger each : nestedList){
      queue.offer(each);
      depth.offer(1);  //only if input is class is NestedInteger(list or integer)
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
