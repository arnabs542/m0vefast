public int histogram(int[] arr){
  int res = 0;
  //stack only save acessing index of colums
  Deque<Integer> stack = new LinkedList<>();
  for(int i = 0; i <= arr.length; i++){
    //need to pop out, add a bar in the end of height 0
    int cur = i == arr.length ? 0 : arr[i];
    //accending order, calculate
    //meet first non-assending? poll previous assending ones
    while(!stack.isEmpty() && cur <= arr[stack.peekFirst()]){
      //vertical height = height of lowest col (left/bottom of stack)
      int height = arr[stack.pollFirst()];
      //determine the left boundary
      int left = stack.isEmpty() ? 0: stack.peekFirst()+1;  //just polled out index
      //update rectangle
      //right = i (new maybe assending index)
      res = Math.max(res, height*(i - left));
    }
    stack.offerFirst(i);
  }
  return res;

}
