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

//max heap implementation
static void heapify(int a[], int n, int i) {
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

//?
//min heap offer operation
public int[] offerHeap(int[] array, int ele) {
    // Write your solution here
  array[array.length - 1] = ele;
  percolationUp(array, array.length-1);
  return array;
}
private void percolationUp(int[] arr, int index){
  int parentIndex = getParentIndex(index);
  if(index != 0){
    if(arr[parentIndex] > arr[index]){
      swap(arr, parentIndex, index);
      percolationUp(arr, getParentIndex);
    }
  }
}
//heap update operation
public int[] updateHeap(int[] array, int index, int ele) {
    // Write your solution here
}
//delete node in heap
public int[] deleteHeap(int[] array, int ele) {
    // Write your solution here
  array[array.length - 1] = ele;
  percolationUp(array, array.length-1);
  return array;
}
