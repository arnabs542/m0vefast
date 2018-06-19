//“a1c0b2c4” → “abbcccc” 2
//char number char number...
//“acb2c4” → “acbbcccc” 1
//char char char number....
https://www.programcreek.com/2014/09/leetcode-decode-string-java/
follow up question:
https://piazza.com/class/j0eqhhdregb3i?cid=29
public String decompress(String input) {
    // Write your solution here
    StringBuilder sb = new StringBuilder();
    char[] arr = input.toCharArray();
    for(int i = 0; i < arr.length; i++){
    	char ch = arr[i++];
      if(Character.isDigit(arr[i])){
        int count = arr[i] - '0';
        for(int c = 0; c < count; c++)
          sb.append(ch);
      }else{
        sb.append(ch);
      }
    }
    return sb.toString();
  }


  public String decodeString(String s) {
          // sanity check
          if (s == null || s.length() == 0) {
              return s;
          }
          int[] index = new int[] { 0 };
          return decode(s, index);
      }

      private String decode(String s, int[] index) {
          StringBuilder sb = new StringBuilder();
          // scan the whole input string to decode it;
          int n = s.length();
          while (index[0] < n && s.charAt(index[0]) != ']') {
              char cur = s.charAt(index[0]);
              if (cur < '0' || cur > '9') { // not a digit;
                  sb.append(cur);
                  index[0]++;
              } else { // it’s a digit; calculate the digits;
                  int cnt = 0;
                  while (index[0] < n && s.charAt(index[0]) >= '0'
                          && s.charAt(index[0]) <= '9') {
                      cnt = 10 * cnt + (s.charAt(index[0]) - '0');
                      index[0]++;
                  }
                  index[0]++; // skip '[';
                  // get the decoded string from its sub-problem;
                  String decodedString = decode(s, index);
                  index[0]++; // skip ']'
                  // repeatedly copy k times;
                  while (cnt > 0) {
                      sb.append(decodedString);
                      cnt--;
                  }
              }
          }
          return sb.toString();
      }

      https://piazza.com/class/j0eqhhdregb3i?cid=491

      //Q4: string decoding inplace version
      public String decode(String input){
      	char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
          char ch = arr[i++];
          int count = arr[i] - '0';
          for(int c = 0; c < count; c++){
            sb.append(ch);
          }
        }
        return sb.toString();
      }
      //for the decoded string is longer: a3, a4, a5
      private int decodeLong(char[] arr, int length){
      	int newLength = length;
      	for(int i = 0; i < length; i++){
      		int digit = getDigit(arr[i]);
      		if(digit > 2 && digit <= 9){
      			newLength += digit - 2;
      		}
      	}
      	char[] res = new char[newLength];
      	int end = newLength -1;
      	//res is longer, do from right to left
      	for(int i = length-1; i >= 0; i--){
      		int digit = getDigit(arr[i]);
      		if(digit > 2 && digit <= 9){
      			i--;
      			for(int j = 0; j < digit; j++){
      				res[end--] = arr[i];
      			}
      		}else{
      			res[end--] = arr[i];
      		}
      	}
      	return new String(res);
      }
      private int getDigit(char digit){
      	return digit - '0';
      }

      //Q4: string decoding not inplace version using sb
      public String decode(String input){
      	char[] arr = input.toCharArray();
      	StringBuilder sb = new StringBuilder();
      	for(int i = 0; i < arr.length; i++){
      		char ch = arr[i++];
      		int count = arr[i] - '0';
      		for(int c = 0; c < count; c++){
      			sb.append(ch);
      		}
      	}
      	return sb.toString();
      }
