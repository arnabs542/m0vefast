//FB：firstKCommonElements
//k common elements in n sorted arrays
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
      while(ptr[j] < arr[j].length ||pivot > arr[j][ptr[j]]){
        ptr[j]++;
      }
      //reach the end of row || not equal (cur > pivot => no common in this row), go to next row
      if(ptr[j] == arr[0].length || pivot != arr[0][ptr[j]]){
        break;
      }
      //there is a match for jth row
      counter++;
      if(counter == n){
        res[index++] = arr[0][ptr[j]];
      }
      if(index == k){
        return res;
      }
    }
    return res;
  }




        for (int i = 0; i < arrays[0].length; i++) {
            int pivot = arrays[0][i];
            int counter = 1;  //for the firs row
            for (int j = 1; j < n; j++) {
              //if cur < pivot, move right
                while (pointers[j] < arrays[j].length && pivot > arrays[j][pointers[j]]) {
                    pointers[j]++;
                }

                if (pointers[j] == arrays[j].length || pivot != arrays[j][pointers[j]]) {
                    break;
                }
                //row count only there is common element
                counter++;

            //after this pivot, if all row contians common element, push to res
            if (counter == n) {
                ret[index++] = pivot;
            }
            if (index == k) {
                return res;
            }
        }

        return res;
    }

//
