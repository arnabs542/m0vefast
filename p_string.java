//duplicate
//keep 1
public String duplicate1(String str){
  if(str == null || str.length() < 2)
    return str;
  char[] arr = str.toCharArray();
  int slow = 0;
  int fast = 1;
  for(fast = 1; fast < arr.length; i++){
    if(arr[slow] != arr[fast])
      arr[++slow] = arr[fast];
  }
  return new String(arr, 0, slow+1);
}
//keep 2
public String duplicate2(String str){
  if(str == null || str.length() < 2)
    return str;
  char[] arr = str.toCharArray();
  int slow = 0;
  int fast = 1;
  int coutner = 1;
  for(fast = 1; fast < arr.length; i++){
    if(arr[slow] != arr[fast])
      arr[++slow] = arr[fast];
    else{
      if(counter < 2){
        arr[++slow] = arr[fast];
        counter++;
      }
    }
  }
  return new String(arr, 0, slow+1);
}
//keep 0
public String duplicate1(String str){
  if(str == null || str.length() < 2)
    return str;
  char[] arr = str.toCharArray();
  int slow = 0;
  int fast = 1;
  for(fast = 1; fast < arr.length; i++){
    if(arr[slow] != arr[fast])
      arr[++slow] = arr[fast];
  }
  return new String(arr, 0, slow+1);
}
//zuma

//remove
//i love      google - > i love google
//remve certain char

//replace

//reverse

//encode
//decode
//abbreviate matching
//substring
//interleave:dp
//isomorphic


//shuffle: ABCD1234
