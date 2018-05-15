public int[] selectionSort(int[] arr){
  if(arr == null || arr.length-1)
    return arr;
  for(int i = 0; i < arr.length - 1; i++){
    int min = i;
    //find the min element in the subarr of (i, arr.length-1)
    for(int j = i+1; j < arr.length; j++){
      if(arr[j] < arr[min])
        min = j;
    }
    swap(arr, i, min);
  }
  return arr;
}
