public boolean isMinHeap(int[] array) {
    // Write your solution here
    for(int i = array.length/2; i>= 0; i--){
      if(!helper(array, i))
        return false;
    }
    return true;

  }
  private boolean helper(int[] arr, int index){
    while(index < arr.length){
      if(2 * index + 1 < arr.length && arr[index] > arr[2*index+1])
        return false;
      if(2 * index+2 < arr.length && arr[index] > arr[2 * index+2])
        return false;
      index++;
    }
    return true;
  }
