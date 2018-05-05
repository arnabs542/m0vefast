//similar t amazon windowSum
public List<Integer> maxWindows(int[] arr, int k) {
    List<Integer> res = new ArrayList<Integer>();
    Deque<Integer> deque = new LinkedList<>();
    for(int i = 0; i < arr.length; i++){
      while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
        deque.pollLast();
      }
      if(!deque.isEmpty() && deque.peekFirst() <= i-k){
        deque.pollFirst();
      }
      deque.offerLast(i);
      if(i >= k-1){
        res.add(arr[deque.peekFirst()]);
      }
    }
    return res;
}
