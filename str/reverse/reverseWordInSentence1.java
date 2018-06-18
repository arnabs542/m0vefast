//no heading or ending white spaces
//no duplicate white space
//eg: “I love Google” → “Google love I”
public String reverseWords(String s) {
        // write your code here
  if(s == null || s.length() == 0)
		return "";
	String[] arr = s.split(" ");
	StringBuilder sb = new StringBuilder();
	for(int i = arr.length -1; i >=0; i--){
		if(!arr[i].equals(" "))
			sb.append(arr[i]).append(" ");
	}
	//if input is " "
	if(sb.length() == 0)
		return "";
	else //remove the last " " from line 11
		return sb.substring(0, sb.length()-1);
		//cant use sb.toString()
    }

//solution2: O(n), O(1)
//can handle heading and ending whitespace, but not duplciate space
//similar to remove duplicate white space
public Stirng reverseWords(String input) {
if(input == null || input.length <= 1)
      return input;
    char[] arr = input.toCharArray();
    int start = 0;
    //int fast = 0;
    //reverse each word=> i evol     oohay
    //reverse(arr, 0, arr.length -1);
   	for(int fast = 0; fast < arr.length; fast++){
      //start index of a word
      if(arr[fast] != ' ' && (fast == 0 || arr[fast-1]== ' '))
         start = fast;
      //end index of a word
      if(arr[fast] != ' ' && (fast == arr.length -1 || arr[fast+1] == ' '))
        reverse(arr, start, fast);
    }
    //reverse the senctence => i yahoo     love i
    reverse(arr, 0, arr.length -1);
    return new String(arr);
  }
  // i love     yahoo
  // i love     yahoo
  // i love     yahoo
  // i love     yahoo
  // i love     yahoo
  // i evol     yahoo
  // i  love    yahoo
  // i  evol    yahoo
  // i   love   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   oohay
  // yahoo   love   i

  private static void reverse(char[] arr, int left, int right){
    if(left > right){
    	return;
    }
    swap(arr, left, right);
    reverse(arr, left+1, right-1);
  }
  private void swap(char[] arr, int left, int right){
  	char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
