//revrse word by word in a science
//eg: i love yahoo -> yahoo love i
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

//soluwion2: O(n), O(1)
public void reverseWords(char[] arr) {
  if(arr == null || arr.length == 0){
    return;
  }
  int left = 0;
  int right = 0;
  while(right < arr.length){
    while(right < arr.length && arr[right] != ''){
      right++;
    }
    reverse(arr, left, right-1);
    start = right-1;
    right++;
  }
  reverse(arr, 0, arr.length-1);
}


//with duplicate white spaces
//"    i love   yahoo" -> "yahoo love i"
