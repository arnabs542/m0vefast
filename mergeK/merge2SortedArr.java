public int[] merge(int[] A, int m, int[] B, int n) {
    // Write your solution here
    if(m == 0) return B;
		if(n == 0) return A;
		int i = 0;
    int j = 0;
    int index = 0;
    int[] arr = new int[m+n];
    while(i < m && j < n){
    	if(A[i] < B[j])
        arr[index++] = A[i++];
      else
        arr[index++] = B[j++];
      }

    while(i < m){
    	arr[index++] = A[i++];
    }
    while(j < n){
    	arr[index++] = B[j++];
    }
    return arr;

  }
