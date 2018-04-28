public int[] arrDup1(int[] arr){
  if(arr == null || arr.length <= 1) return arr;
  int fast = 1;
  int slow = 1;
  for(fast = 1; fast < arr.length; fast++){
    if(arr[fast] == arr[slow-1]) continue;
    arr[slow++] = arr[fast];
  }
  return Arrays.copyOf(arr, slow);
}
public int[] arrDup2(int[] arr){
  if(arr == null || arr.length <= 1) return arr;
  int slow = 2;
  int fast = 2;
  for(fast = 2; fast < arr.length; fast++){
    if(arr[fast] == arr[slow-2]) continue;
    arr[slow++] = arr[fast];
  }

  return Arrays.copyOf(arr, slow);
}
public int[] arrDup3(int[] arr){
  if(arr == null || arr.length <= 1) return arr;
  int slow = 0;
  int fast = 0;
  while(fast < arr.length){
    int start = fast; //start of the duplicate if duplicate
    while(fast < arr.length && arr[fast] == arr[start]){
      fast++;
    }
    if(fast - start == 1){
      arr[slow++] = arr[start];
    }
  }
  return Arrays.copyOf(arr, slow);
}
public int[] arrDup4(int[] arr){
  if(arr == null || arr.length <= 1) return arr;
  int slow = -1;  //the top
  int fast = 0;
  while(fast < arr.length){
    if(slow == -1 || arr[fast] != arr[slow]){
      arr[++slow] == arr[fast];
    }else{
      while(fast+1 < arr.length && arr[fast+1] == arr[slow]){
        fast++;
      }
      slow--
    }
  }
  return Arrays.copyOf(arr, slow+1);
}
