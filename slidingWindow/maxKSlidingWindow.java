//Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
//for max number's index in each window k
https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
public List<Integer> maxKWindows(int[] arr, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();  //save index
    for(int i = 0; i < arr.length; i++){
      // For every element, the previous smaller elements are useless so remove them from deque， keep bigIndex at leftside,
      //deque is decesding in array's value
      // Remove all elements smaller than the currently being added element (remove useless elements)
      while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
        deque.pollLast();
      }
      //Remove the elements which are out of this window
      if(!deque.isEmpty() && deque.peekFirst() <= i-k){
        deque.pollFirst();
      }
      // Add new element at rear of queue
      deque.offerLast(i);
      //from the first window on: for each window, add the largest(peekfirst) in the res
      if(i + 1 >= k){
        res.add(arr[deque.peekFirst()]);
      }
    }
    return res;
}
