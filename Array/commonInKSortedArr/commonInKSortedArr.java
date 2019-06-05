//FB：firstKCommonElements
//k common elements in n sorted arrays  O(n^2) O(n)
//https://blog.csdn.net/yaokai_assultmaster/article/details/53938792
public int[] firstKCommonElements(int[][] arr, int k) {

  if(arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0){
    return new int[]{};
  }
  int[] res = new int[k];
  int n = arr.length;
  int[] ptr = new int[n];   //n pointer to track each row scan, index = row_id, value = col_id of that row
  int index = 0;
  for(int i = 0; i < arr[0].length; i++){
    int pivot = arr[0][i];
    int counter = 1;
    for(int j = 1; j < n; i++){
      //if pivot > cur number, move cur to tht right
      while(ptr[j] < arr[j].length && pivot > arr[j][ptr[j]]){
        ptr[j]++;
      }
      //reach the end of row || not equal (cur > pivot => no common in this row), go to next row
      if(ptr[j] == arr[0].length || pivot != arr[j][ptr[j]]){
        break;
      }
      //there is a match for jth row
      counter++;
      if(counter == n){
        res[index++] = pivot;
      }
      if(index == k){
        return res;
      }
    }
    return res;
  }
