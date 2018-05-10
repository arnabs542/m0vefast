//“a1c0b2c4” → “abbcccc”
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
