//localmin:i is smaller than arr[i-1] and arr[i+1]
//assuption: no duplicate
//           unsorted
public int localMinimum(int[] arr) {
    // Write your solution here
    return helper(arr, 0, arr.length-1);
}

private int helper(int [] arr, int start, int end){
  //find the mid
  int mid = start + (end-start)/2;
  int size = arr.length;

  //check the local minima (element is smaller than its left and right neighbors)
  //first check if left and right neighbor exists
  if((mid == 0 || arr[mid-1] > arr[mid]) && (mid == size-1 || arr[mid+1] > arr[mid]))
      return arr[mid];
  //check if left neighbor is less than mid element, if yes go left
  else if(mid > 0 && arr[mid] > arr[mid-1]){
      return helper(arr, start, mid-1);
  }else { //if(mid<size-1 && arrA[mid]>arrA[mid+1])
      return helper(arr, mid+1, end);
  }

}
// Check if mid element is smaller than its left and right neighbors.
// If left neighbor is less than the mid element then make a recursive call to the left half of the array.
//   (There will be at least one local minima in the left half, take few examples to check)
// If right neighbor is less than the mid element then make a recursive call to the right half of the array.
