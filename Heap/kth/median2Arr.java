//https://gist.github.com/NoelAnnParisi/2dac2d119c09b2699f9b11526f672ad8
//https://code.laioffer.com/ui/#/app/problem/203
public double median(int[] a, int[] b) {
    // write your solution here
    //mergesort a b
    mergeSort(a);
		mergeSort(b);
    //find median of 2 sorted arr
    return findMedian(a,b);
  }
  private int[] mergeSort(int[] arr){
    if(arr == null || arr.length <2)
      return arr;
    int[] temp = new int[arr.length];
    divide(arr, temp, 0, arr.length-1);
    return arr;
  }
  private void divide(int[] arr, int[] temp, int left, int right){
  	if(left >= right)
      return;
    int mid = left + (right - left)/2;
    divide(arr, temp, left, mid);
    divide(arr, temp, mid+1, right);
  	merge(arr, temp, left, mid, right);

  }
  private void merge(int[] arr, int[] temp, int left, int mid, int right){
  	for(int i = left; i <= right; i++){
    	temp[i] = arr[i];
    }
    int leftIndex = left;
    int rightIndex = mid+1;
    while(leftIndex <= mid && rightIndex <= right){
    	if(temp[leftIndex] <= temp[rightIndex])
        arr[left++] = temp[leftIndex++];
      else
        arr[left++] = temp[rightIndex++];
    }
    while(leftIndex <= mid)
      arr[left++] = temp[leftIndex++];
  }

  public double findMedian(int[] a, int[] b) {
    // Write your solution here
   	int alen = a.length;
    int blen = b.length;
    if((alen+blen)%2==0){
    	int r1 = helper(a, 0, b, 0, (alen+blen)/2);
      int r2 = helper(a, 0, b, 0, (alen+blen)/2+1);
      return (r1 + r2)/2.0;
    }
    return (double)helper(a, 0, b, 0, (alen+blen)/2+1);
  }
  private int helper(int[] a, int aleft, int[] b, int bleft, int k){
  	//basecase
    if(aleft >= a.length) return b[bleft+k-1];
    if(bleft >= b.length) return a[aleft+k-1];
    if(k == 1) return Math.min(a[aleft], b[bleft]);
    int ak = aleft + k/2 - 1 < a.length ? a[aleft+k/2-1] : Integer.MAX_VALUE;
    int bk = bleft + k/2 - 1 < b.length ? b[bleft+k/2-1] : Integer.MAX_VALUE;
    if (ak < bk){
    	return helper(a, aleft+k/2, b, bleft, k-k/2);
    }
    return helper(a, aleft, b, bleft+k/2, k-k/2);
  }



//solution2: alternative using quickselect
public double median(int[] a, int[] b) {
	// not sorted arrays
	// need do quick select
	// combine two arrays first
	int[] array = new int[a.length + b.length];
	// laicode doesn't support the following arraycopy: Invalid dependency java/lang/System
	// work OK in eclipse
	//System.arraycopy(a, 0, array, 0, a.length);
	//System.arraycopy(b, 0, array, a.length, b.length);
	int c = 0;
	for (int num : a) {
		array[c++] = num;
	}
	for (int num : b) {
		array[c++] = num;
	}
	if (array.length % 2 != 0) {
		return helper(array, 0, array.length - 1, array.length / 2);
	} else {
		return (helper(array, 0, array.length - 1, array.length / 2 - 1)
    + helper(array, 0, array.length - 1, array.length / 2)) / 2;
	}
}

private double helper(int[] array, int left, int right, int k) {
	int pivotIndex = findPivot(array, left, right);
	if (pivotIndex == k) {
		return (double) array[pivotIndex];
	}
	if (pivotIndex < k) {
		return helper(array, pivotIndex + 1, right, k);
	} else {
		return helper(array, left, pivotIndex - 1, k);
	}
}
private int findPivot(int[] array, int left, int right) {
	if (left >= right) {
		return left;
	}
	// pick the middle one as the pivot;
	int mid = left + (right - left) / 2;
	swap(array, mid, right);
	int i = left;
	int j = right - 1;
	while (i <= j) {
		if(array[i] <= array[right]) {
			i++;
		} else {
			swap(array, i, j);
			j--;
		}
	}
	swap(array, i, right);
	return i;
}

private void swap(int[] array, int i, int j) {
	int tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
}
