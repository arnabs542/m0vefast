//solution1:
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


//another solution
public int[] kClosest(int[] arr, int target, int k){
  if(array == null || array.length == 0)
    return array;
  if(k == 0)
    return new int[0];
  //left is the index of the smallest/biggest element
  //left and right are closet to target
  int left = largestSmallestEqual(arr, target);
  int right = left + 1;
  int[] res = new int[k];
  for(int i = 0; i < k; i++){
    //merge if 1) right out of bound
    //         2) left, right in bound, but arr[left] closer to target
    if(right >= array.length || left >= 0 && Math.abs(target - arr[left]) <= Math.abs(arr[right] - target))
      res[i] = arr[left--];
    else
      res[i] = arr[right++];
  }
  return res;
}
//find the largest smaller or equal element's index in the arr
//last occurance
private int largestSmallestEqual(int[] arr, int target){
  int left = 0;
  int right = arr.length - 1;
  while(left + 1 < right){
    int mid = left + (right - left)/2;
    if(arr[mid] <= target)
      left = mid;
    else
      right = mid;
  }
  //notice its <= here not ==
  //right can only be == to target, not smaller than target
  if(arr[right] == target)
    return right;
  if(arr[left] <= target)
    return left;
  return -1;
}
