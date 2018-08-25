public boolean isMinHeap(int[] array) {
    // Write your solution here
  }
  //compare 
  //heapSort: build heap
  public int[] buildheap(int[] arr) {
      // Write your solution here
      for(int i = arr.length/2; i >= 0; i--){
        heapify(arr, i);
      }
      return arr;
    }
  //iteration : minheap
  private void heapify(int[] A, int k){
    while (k < A.length) {
      int smallest = k;
      int leftIndex = k * 2 + 1;
      int rightIndex = k * 2 + 2;
      //left and right childrens should be bigger than parent s
      if (leftIndex < A.length && A[leftIndex] < A[smallest]) {
          smallest = leftIndex;
      }
      if (rightIndex < A.length && A[rightIndex] < A[smallest]) {
          smallest = rightIndex;
      }
      if (smallest == k) {
          break;
      }
      swap(A, smallest, k);
      //keep making k the smallest one and check
      k = smallest;
    }
  }
