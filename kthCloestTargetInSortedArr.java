//logn+logk+k
//先用logn找到closest element, closest两侧和target的差值刚好是两个sorted array，
//可以用找kth smallest in two sorted array的方法来O(lgk)做


public int[] kthCloest(int[] arr, int target){
  //closet in sorted arr lgn
  if(arr == null || arr.length <= 1)
    return arr;
  int[] res = new int[k];
  int index = 0;
  int left = 0;
  int right = arr.length-1;
  while(left + 1 < right){
    int mid = left + (right - left)/2;
    if(arr[mid] == target)
      res[index++] = arr[mid];
    else if(arr[mid] < target)
      left = mid;
    else
      right = mid;
  }
  //kth smallest in 2 sorted arr, k+lgk?
  //https://yisuang1186.gitbooks.io/-shuatibiji/k_closest_number_in_sorted_array.html
  while(index <= k-1){
    if(left < 0 && right >= arr.length){
      break;
    }
    if(left < 0){
      res[index++] = arr[right++];
      continue;
    }
    if(right >= arr.length){
      res[index++] = arr[left--];
      continue;
    }
    if(Math.abs(arr[left] - target) > Matth.abs(arr[right] - target)){
      res[index++] = arr[left--];
    }else{
      res[index++] = arr[right++];
    }
  }
  return res;
}
