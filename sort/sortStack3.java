//?i < j < k and a[i] < a[j] < a[k].
//因为标签是easy我觉得可能我想得太复杂了，于是我又想到用stack做不断pop前面出现过比array【i】大的数，
//stack.size() >= 3时返回true时间复杂度是O（n），空间是O（3）？
public boolean existIJK(int[] array) {
  Deque<Integer> stack = new LinkedList<>();
  for(int i = 0; i < array.length; i++){
    if(!stack.isEmpty() && stack.peek() >= array[i]){
      stack.poll();
    }
    stack.offer(array[i]);
    if(stack.size() == 3){
      return true;
    }
  }
  return false;
}
