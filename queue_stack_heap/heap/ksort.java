// Given an unsorted integer array, each element is at most k step from its position after the array is sorted.
// Can you sort this array with time complexity better than O(nlogn)? -> O(n log k)
//Sort a nearly sorted, 常规的k size heap
//http://massivealgorithms.blogspot.com/2014/06/sort-nearly-sorted-or-k-sorted-array.html
public int[] ksort(int[] arr, int k) {
  if(arr == null || arr.length == 0)
    return arr;
  PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
  for(i = 0; i < k+1; i++)
    minHeap.offer(arr[i]);
  int index = 0;
  while(!minHeap.isEmpty()) {
    arr[index++] = minHeap.poll();
    if(i < input.length)
      minHeap.offer(arr[i++]);  //maintann size k+1
    //index++;
    //i++;
  return arr;
}
1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time
2) One by one remove min element from heap, put it in result array,
3) and add a new element to heap from remaining elements.
Removing an element and adding a new element to min heap will take Logk time. So overall complexity will be O(k) + O((n-k)*logK)
