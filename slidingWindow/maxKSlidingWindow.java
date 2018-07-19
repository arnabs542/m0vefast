//similar t amazon windowSum   n,k
//Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
//for max number's index in each window k
https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
public List<Integer> maxKWindows(int[] arr, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();  //save index
    for(int i = 0; i < arr.length; i++){
      // For every element, the previous smaller elements are useless so remove them from deque， keep big at leftside
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
        // Create a Double Ended Queue, deque that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in deque, i.e.,
        // arr[deque.front[]] to arr[deque.rear()] are sorted in decreasing order
        Deque<Integer> deque = new LinkedList<Integer>();
        /* Process first k (or first window) elements of array */
        for(int i = 0; i < k; ++i){
            // For every element, the previous smaller elements are useless so remove them from deque
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
                deque.removeLast();   // Remove from rear
            // Add new element at rear of queue
            deque.addLast(i);
        }
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i){
            // The element at the front of the queue is the largest element of previous window, so print it
            // System.out.print(arr[deque.peek()] + " ");
            // Remove the elements which are out of this window
            while(!deque.isEmpty() && deque.peek() <= i-k)
                deque.removeFirst();
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!deque.isEmpty()) && arr[deque.peekLast()] <= arr[i])
                deque.removeLast();
            // Add current element at the rear of deque
            deque.addLast(i);

        }
        // Print the maximum element of last window
        //System.out.print(arr[deque.peek()]);
    }
