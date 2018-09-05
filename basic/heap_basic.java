// swapup: offer() update()
// swapdown: poll() update() heapify()//swapdown
//1) heapify opearation
//O(n): 从下往上 从右往左 swap down 最后一个node 的index 是n-1, parent is (n-1)/2
public int[] heapify(int[] arr) {
    //for each node that has child, do swapdown()
    for(int i = arr.length/2; i >= 0; i--){
      percolationDown(arr, i);
    }
    return arr;
  }
//iteration : minheap
private void percolationDown(int[] arr, int index){
  //while (k < arr.length) {
  while(index < arr.length){
    int smallest = k;
    int leftIndex = k * 2 + 1;
    int rightIndex = k * 2 + 2;
    //left and right childrens should be bigger than parent s
    if (leftIndex < arr.length && arr[leftIndex] < arr[smallest]) {
        smallest = leftIndex;
    }
    if (rightIndex < arr.length && arr[rightIndex] < arr[smallest]) {
        smallest = rightIndex;
    }
    if (smallest == k) {
        break;
    }
    swap(arr, smallest, k);
    k = smallest;
  }
}
//2) update heap operation
public int[] updateHeap(int[] array, int index, int ele) {
    // Write your solution here
    int old = array[index];
    array[index] = ele;
    if(old > ele)
      swapUp(array, index);
    else
      swapDown(array, index);
    return array;
  }
  private void swapUp(int[] array, int index){
    int parentIndex = (index - 1) / 2;
    if(index != 0){
      if(array[parentIndex] > array[index]){
        swap(array, index, parentIndex);
         swapUp(array, parentIndex);
      }
    }
  }
  private void swapDown(int[] array, int index){
    while(index < array.length){
      int smallest = index;
      int left = index * 2 + 1;
      int right = index * 2 + 2;
      if(left< array.length && array[left] < array[smallest])
        smallest = left;
      if(right < array.length && array[right] < array[smallest])
        smallest = right;
      if(smallest == index)
        break;
      swap(array, smallest, index);
      index = smallest;

    }
  }
  private void swap(int[] arr, int left, int right){
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
private int getParentIndex(int child_index){
  return (child_index - 1)/2;
}
//2) offer operation
//assume: The last celll of the array is not used.
public int[] offer(int ele) {
    // Write your solution here
  arr[arr.length-1] = ele;
  percolationUp(arr, arr.length-1);
  return arr;
}

//delete node in heap
public int[] poll() {
  int res = arr[0];
  arr[0] = arr[arr.length-1];
  percolationDown(0);
  return res;
}
//heapSort: O(nlgn: buildheap + poll)
//max heap implementation
public void heapify(int a[], int n, int i) {
    int max, child;
    child = 2 * i + 1;
    max = i;
    if (child < n)
      if (a[child] > a[max])
        max = child;
    if (child + 1 < n)
      if (a[child + 1] > a[max])
        max = child + 1;
    if (max != i) {
      int temp = a[i];
      a[i] = a[max];
      a[max] = temp;
      heapify(a, n, max);
    }
  }
