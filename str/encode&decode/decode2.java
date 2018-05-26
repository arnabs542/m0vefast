//“a1c0b2c4” → “abbcccc” 2
//char number char number...
//“acb2c4” → “acbbcccc” 1
//char char char number....
public String decompress2(String input) {
    // Write your solution here.
    StringBuilder sb = new StringBuilder();
    char[] arr = input.toCharArray();
    for(int i = 0; i < arr.length; i++){
    	char ch = arr[i++];
      int count = arr[i] - '0';
      for(int c = 0; c < count; c++)
        sb.append(ch);
    }
    return sb.toString();
  }

https://piazza.com/class/j0eqhhdregb3i?cid=2154
//solution2: less space
public String decompress2(String input) {
    int extra = 0 ;
    for (int i = 1; i < input.length(); i = i + 2) {
      if (input.charAt(i) - '0' > 2 && input.charAt(i) - '0' <= 9) {
        extra += (input.charAt(i) - '0' - 2);
      }else{
        extra -= (2 - input.charAt(i) + ‘0’);
      }
    }
    char[] temp = new char[input.length() + extra] ;
    int fast = 1 ;
    int slow = 0 ;
    while (fast < input.length()) {
      char cur = input.charAt(fast - 1) ;
      for (int i = 1; i <= (input.charAt(fast) - '0'); i++) {
        temp[slow] = cur ;
        slow++ ;
      }
      fast += 2 ;
    }
    return new String(temp) ;
  }
