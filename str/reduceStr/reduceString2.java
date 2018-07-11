//Q2: remove adjacent duplicated and keep 2 duplicate
public String reduceString2(String s){
    if(s == null || s.length() <= 1)
        return s;
    char[] arr = s.toCharArray();
    int slow = 0;
    int fast = 1;
    int counter = 1;
    for(fast = 1; fast< arr.length; fast++){
        if(arr[fast] != arr[slow]){
            counter++;
            arr[++slow] = arr[fast];
        }else{
            if(counter < 2){
                counter++;
                arr[++slow] = arr[fast];
            }
        }
    }
    return new String(arr, 0, slow);
}


 if(array.length <= 1)
        return array;
    int slow = 2;
    int fast = 2;
    for(fast = 2; fast < array.length; fast++){
      if(array[fast] == array[slow-2]){
        continue;
      }
      array[slow++] = array[fast];
    }

    return Arrays.copyOf(array, slow);