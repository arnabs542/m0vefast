public boolean isAlphaPalindrome(String s){
	if(input == null || input.length() <= 1)
      return true;
   char[] arr = input.toCharArray();
    int left = 0;
    int right = arr.length-1;
    while(left < right){
      if(!Character.isLetterOrDigit(arr[left]))
        left++;
      else if(!Character.isLetterOrDigit(arr[right]))
        right--;
      else if(arr[left] != arr[right])
        return false;
      else{
        left++;
        right--;
      }
    }
    return true;
}
