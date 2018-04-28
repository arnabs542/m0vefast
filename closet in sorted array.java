//solution1
public int closet(int[] arr, int target){
	if(arr == null || arr.length == 0)
		return -1;

	int index = firstIndex(arr, target);
	if(index == 0)
		return 0;
	if(index == array.length)
		return arr.length -1;
	if(target - arr[index-1] < arr[index] - target)
		return index -1;
	return index;
}
private int firstIndex(int[] arr, int target){
	int left = 0; 
	int right = arr.length -1;
	while(left + 1 < right){
		int mid + left + (right - left)/2;
		if(arr[mid] < target)
			left = mid;
		else
			right = mid;
	}
	if(arr[left] >= target)
		return left;
	if(arr[right] >= target)
		return right;
	return arr.length;
}
//solution2:
public int cloestNumber(int[] a, int target){
    if(a == null || a.length == 0)
        return -1;
    int start = 0;
    int end = a.length-1;
    while(start + 1 < end){
        int mid = start + (end - start)/2;
        if(a[mid] == target)
            return mid;
        if(a[mid] < target)
            start = mid;
        else 
            end = mid;
    }
    if(Math.abs(a[start] - target) <= Math.abs(a[end] - target))
        return start;
    return end;
}
//other solutions
//solutino1: for-loop 
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int dis = 0;
        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 0; i<A.length; i++){
            dis = A[i]-target;
            if (dis < 0){
                dis = -dis;
            }
            if(dis <= min){
                min = dis;
                result = i;
            }
        }
        return result; 
    }
//solution2: binary search 
    public int closestNumber(int[] A, int target) {
         if(A == null || A.length == 0){
             return -1;
         }
        int left = 0;
        int right = A.length - 1;
        int[] result = binarySearch(A, target, left, right);
        if (Math.abs(A[result[0]]-target) >= Math.abs(A[result[1]] - target)){
            return result[1];
        }
        return result[0];

    }
    public int[] binarySearch(int[] A, int target, int left, int right) {
        int mid = (left + right) / 2;         // left + (right - left) / 2;
        int[] result = new int[2];
//terminating conditions:
        if(right - left <= 1){   //<: consider A has only 1 element 
            result[0] = left;
            result[1] = right;
            return result;
        }
        if (A[mid] == target){
            result[0] = mid;
            result[1] = mid;
            return result;
        }else if(A[mid] < target){  
//what about mid+1, leading to terminating condition: right < left 
            return binarySearch(A, target, mid, right);
        }else{    //what about mid-1
            return binarySearch(A, target, left, mid);
        }
    }
}
